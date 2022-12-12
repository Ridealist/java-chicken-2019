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

    public int totalPrice() {
        int totalPrice = 0;
        for (Menu menu : orderHistory.keySet()) {
            int orderQuantity = orderHistory.get(menu);
            int menuPrice = menu.getPrice();
            totalPrice += orderQuantity * menuPrice;
        }
        return totalPrice;
    }

    public int orderNumberOfChickenCategory() {
        int numberOfChickenCategory = 0;
        for (Menu menu : orderHistory.keySet()) {
            if (menu.isChickenCategory()) {
                numberOfChickenCategory += orderHistory.get(menu);
            }
        }
        return numberOfChickenCategory;
    }

    public Map<Menu, Integer> getOrderHistory() {
        return orderHistory;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
