package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int menuAmount;

    public Order(Table table, Menu menu, int menuAmount) {
        this.table = table;
        this.menu = menu;
        this.menuAmount = menuAmount;
    }

    // TODO 필요없는 메서드 제거
    @Override
    public String toString() {
        return "오더";
    }

    public Table getTable() {
        return table;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getMenuAmount() {
        return menuAmount;
    }
}
