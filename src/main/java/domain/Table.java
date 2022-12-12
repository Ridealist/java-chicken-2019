package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orderStatus = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSame(String number) {
        return String.valueOf(this.number).equals(number);
    }

    public void addOrder(Menu menu, int menuQuantity) {
        orderStatus.put(menu, menuQuantity);
    }

    public boolean hasOrder() {
        return !orderStatus.isEmpty();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
