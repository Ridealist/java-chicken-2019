package view;

import controller.Command;
import domain.menu.Menu;
import domain.order.OrderRepository;
import domain.pay.Pay;
import domain.pay.PayMethod;
import domain.table.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String ERROR = "[ERROR]";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";
    private static final String UN_ORDERED_BOTTOM_LINE = "─";
    private static final String ORDERED_BOTTOM_LINE = "#";
    private static final String PAY_MESSAGE = "## %s번 테이블의 결제를 진행합니다.";
    private static final String ORDER_LIST_FORMAT = "%s %s %s";

    public static void printError(String message) {
        System.out.println(ERROR + message);
        System.out.println();
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
        printBottomLine(tables);
        System.out.println();
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

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            printTableBottom(table);
        }
        System.out.println();
    }

    private static void printTableBottom(Table table) {
        if (OrderRepository.hasOrdersOnTable(table)) {
            System.out.printf(BOTTOM_LINE_FORMAT, ORDERED_BOTTOM_LINE);
            return;
        }
        System.out.printf(BOTTOM_LINE_FORMAT, UN_ORDERED_BOTTOM_LINE);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderList(final Pay pay) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        Map<Menu, Integer> menuCounts = pay.aggregateMenus();
        for (Menu menu : menuCounts.keySet()) {
            System.out.printf(ORDER_LIST_FORMAT, menu.getName(), menuCounts.get(menu),
                    menu.getPrice() * menuCounts.get(menu));
            System.out.println();
        }
        System.out.println();
    }

    public static void printPay(final Pay pay) {
        System.out.printf(PAY_MESSAGE, pay.getTable().getNumber());
        System.out.println();
    }

    public static void printFinalCost(final Pay pay, PayMethod payMethod) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(pay.getDiscountPrice(payMethod) + "원");
        System.out.println();
    }
}
