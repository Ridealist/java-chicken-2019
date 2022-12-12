package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Pay {
    private static final int MENU_DISCOUNT_CRITERIA = 10;
    private static final int DISCOUNT_PRICE = 10_000;

    private final Table table;
    private final List<Order> orders;

    public Pay(Table table) throws IllegalArgumentException {
        validateOrderOnTable(table);
        this.table = table;
        this.orders = OrderRepository.getOrdersByTable(table);
    }

    private void validateOrderOnTable(Table table) {
        if (!OrderRepository.hasOrdersOnTable(table)) {
            throw new IllegalArgumentException("선택된 테이블은 주문 내역이 없어 결제할 수 없습니다.");
        }
    }

    // TODO 리팩터링 하기!
    public Map<Menu, Integer> aggregateMenus() {
        Map<Menu, Integer> menusCounts = new HashMap<>();
        for (Menu menu : getUniqueMenus()) {
            menusCounts.put(menu, countMenusFormOrders(menu));
        }
        return menusCounts;
    }

    private Set<Menu> getUniqueMenus() {
        return orders.stream()
                .map(Order::getMenu)
                .collect(Collectors.toSet());
    }

    private int countMenusFormOrders(Menu menu) {
        return orders.stream()
                .filter(order -> order.getMenu().equals(menu))
                .map(Order::getMenuAmount)
                .mapToInt(menuAmount -> menuAmount)
                .sum();
    }

    public int getDiscountPrice(PayMethod payMethod) {
        int cost = getOriginalTotalCost() - calculateMenuDiscount();
        return (int) calculatePayDiscount(cost, payMethod);
    }

    private int getOriginalTotalCost() {
        List<Order> orders = OrderRepository.getOrdersByTable(table);
        return orders.stream()
                .map(order -> order.getMenu().getPrice() * order.getMenuAmount())
                .mapToInt(cost -> cost)
                .sum();
    }

    private int calculateMenuDiscount() {
        int menuCount = OrderRepository.countMenuAmountByTableAndCategory(table, Category.CHICKEN);
        return (menuCount / MENU_DISCOUNT_CRITERIA) * DISCOUNT_PRICE;
    }

    private double calculatePayDiscount(int cost, PayMethod payMethod) {
        return payMethod.getDiscountPrice(payMethod, cost);
    }

    public Table getTable() {
        return table;
    }
}
