package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void save(Table table, Menu menu, int menuAmount) {
        orders.add(new Order(table, menu, menuAmount));
    }

    public static List<Order> findOrdersByTable(Table table) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toList());
    }

    public static List<Order> orders() {
        return Collections.unmodifiableList(orders);
    }
}
