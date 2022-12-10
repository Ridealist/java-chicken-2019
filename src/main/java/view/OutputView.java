package view;

import controller.Command;
import domain.Menu;
import domain.Order;
import domain.Pay;
import domain.Table;

import java.util.List;

public class OutputView {
    public static final String ERROR = "[ERROR]";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String PAY_MESSAGE = "%s번 테이블의 결제를 진행합니다.";

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }

    public static void printMain() {
        System.out.println("## 메인화면");
        for (Command command : Command.values()) {
            System.out.println(command.toString());
        }
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    // TODO 주문 내역 잘못 나오는 것 수정
    public static void printOrderList(final List<Order> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Order order : orders) {
            System.out.println(order.getMenu().toString());
        }
    }

    public static void printPay(final Table table) {
        System.out.printf(PAY_MESSAGE, table.getNumber());
        System.out.println();
    }

    public static void printFinalCost(final Pay pay) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(pay.getDiscountPrice() + "원");
        System.out.println();
    }
}
