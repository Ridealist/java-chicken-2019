package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    public static final int MENU_ORDER_COUNT_UPPER_BOUND = 99;
    private static final List<Order> orders = new ArrayList<>();

    public static void save(Table table, Menu menu, int menuAmount) throws IllegalArgumentException {
        validateMenuCount(table, menu, menuAmount);
        orders.add(new Order(table, menu, menuAmount));
    }

    public static void delete(Pay pay) {
        List<Order> ordersOnTable = orders.stream()
                .filter(order -> order.getTable().equals(pay.getTable()))
                .collect(Collectors.toUnmodifiableList());
        orders.removeAll(ordersOnTable);
    }

    // TODO 메뉴 당 개수가 아닌, 전체 개수가 넘으면 오류 발생하는 에러 해결!
    private static void validateMenuCount(Table table, Menu menu, int menuAmount) {
        if (countMenuAmountByTable(table, menu) + menuAmount > MENU_ORDER_COUNT_UPPER_BOUND) {
            throw new IllegalArgumentException("테이블 당 한 메뉴를 최대 99개까지만 주문할 수 있습니다.");
        }
    }

    private static int countMenuAmountByTable(Table table, Menu menu) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().equals(menu))
                .map(Order::getMenuAmount)
                .mapToInt(menuAmount -> menuAmount)
                .sum();
    }

    public static boolean hasOrdersOnTable(Table table) {
        return orders.stream()
                .anyMatch(order -> order.getTable().equals(table));
    }

    // TODO query를 효율적으로 보내도록 필드별 파라미터를 처음부터 설정
    public static int countChickenMenuByTable(Table table) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().getCategory().equals(Category.CHICKEN))
                .map(Order::getMenuAmount)
                .mapToInt(menuAmount -> menuAmount)
                .sum();
    }

    public static List<Order> getOrdersByTable(Table table) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toUnmodifiableList());
    }
}
