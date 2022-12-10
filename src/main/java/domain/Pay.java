package domain;

import java.util.List;

public class Pay {
    private static final int MENU_DISCOUNT_CRITERIA = 10;
    private static final int DISCOUNT_PRICE = 10_000;

    private final Table table;
    private final PayMethod payMethod;

    public Pay(Table table, int number) throws IllegalArgumentException {
        this.table = table;
        this.payMethod = PayMethod.getMethodByNumber(number);
    }

    public int getDiscountPrice() {
        int cost = getOriginalTotalCost() - calculateMenuDiscount();
        return (int) calculatePayDiscount(cost);
    }

    private int getOriginalTotalCost() {
        List<Order> orders = OrderRepository.getOrdersByTable(table);
        return orders.stream()
                .map(order -> order.getMenu().getPrice() * order.getMenuAmount())
                .mapToInt(cost -> cost)
                .sum();
    }

    private int calculateMenuDiscount() {
        int menuCount = OrderRepository.countChickenMenuByTable(table);
        return (menuCount / MENU_DISCOUNT_CRITERIA) * DISCOUNT_PRICE;
    }

    private double calculatePayDiscount(int cost) {
        return payMethod.getDiscountPrice(payMethod, cost);
    }
}
