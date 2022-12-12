package domain;

public class Order {
    public static final int AMOUNT_PER_MENU_UPPER_BOUND = 99;
    private final Table table;
    private final Menu menu;
    private final int menuAmount;

    public Order(Table table, Menu menu, int menuAmount) throws IllegalArgumentException {
        this.table = table;
        this.menu = menu;
        validateAmountOnMenu(table, menu, menuAmount);
        this.menuAmount = menuAmount;
    }

    private static void validateAmountOnMenu(Table table, Menu menu, int menuAmount) {
        int orderedMenuAmount = OrderRepository.countMenuAmountByTable(table, menu);
        if (orderedMenuAmount + menuAmount > AMOUNT_PER_MENU_UPPER_BOUND) {
            throw new IllegalArgumentException("테이블 당 한 메뉴를 최대 99개까지만 주문할 수 있습니다.");
        }
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
