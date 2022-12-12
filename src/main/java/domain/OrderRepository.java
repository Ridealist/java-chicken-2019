package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void add(Order order) {
        orders.add(order);
    }

    public static void delete(Pay pay) {
        orders.removeAll(getOrdersByTable(pay.getTable()));
    }

    public static List<Order> getOrdersByTable(final Table table) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toUnmodifiableList());
    }

    public static int countMenuAmountByTable(final Table table, final Menu menu) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().equals(menu))
                .map(Order::getMenuAmount)
                .mapToInt(menuAmount -> menuAmount)
                .sum();
    }

    // TODO query를 효율적으로 보내도록 필드별 파라미터를 처음부터 설정할 수는?
    public static int countMenuAmountByTableAndCategory(final Table table, final Category category) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().getCategory().equals(category))
                .map(Order::getMenuAmount)
                .mapToInt(menuAmount -> menuAmount)
                .sum();
    }

    public static boolean hasOrdersOnTable(final Table table) {
        return orders.stream()
                .anyMatch(order -> order.getTable().equals(table));
    }

    public static boolean hasAnyOrders() {
        return !orders.isEmpty();
    }
}
