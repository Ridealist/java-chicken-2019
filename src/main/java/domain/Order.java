package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int menuCount;

    public Order(Table table, Menu menu, int menuCount) {
        this.table = table;
        this.menu = menu;
        this.menuCount = menuCount;
    }

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

    public int getMenuCount() {
        return menuCount;
    }
}
