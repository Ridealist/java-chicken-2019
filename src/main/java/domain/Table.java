package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orderHistory = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSame(String number) {
        return String.valueOf(this.number).equals(number);
    }

    public void addOrder(Menu menu, int menuQuantity) {
        orderHistory.put(menu, menuQuantity);
    }

    public boolean hasOrder() {
        return !orderHistory.isEmpty();
    }

    public Map<Menu, Integer> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
