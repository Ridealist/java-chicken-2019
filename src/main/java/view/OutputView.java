package view;

import domain.Menu;
import domain.Table;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MARKED_LINE = "└ # ┘";

    public static void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printMainScreen() {
        System.out.println(Message.MAIN_SCREEN.message);
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printMarkedLine(tables);
        System.out.println();
    }

    private static void printMarkedLine(List<Table> tables) {
        for (int index = 0; index < tables.size(); index++) {
            if (tables.get(index).hasOrder()) {
                System.out.print(MARKED_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
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


    public static void printOrderHistory(Map<Menu, Integer> orderHistory) {
        System.out.println(Message.ORDER_HISTORY.message);
        for (Menu menu : orderHistory.keySet()) {
            System.out.printf(Message.ORDER_HISTORY_FORMAT.message,
                    menu.getName(), orderHistory.get(menu), menu.getPrice() * orderHistory.get(menu));
        }
        System.out.println();
    }

    public static void printStartPayment(int number) {
        System.out.printf(Message.START_PAYMENT.message, number);
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(Message.TOTAL_PRICE.message, totalPrice);
        System.out.println();
    }

    private enum Message {
        MAIN_SCREEN("## 메인화면\n"
                + "1 - 주문등록\n"
                + "2 - 결제하기\n"
                + "3 - 프로그램 종료"),
        ORDER_HISTORY("## 주문 내역\n"
                + "메뉴 수량 금액"),
        ORDER_HISTORY_FORMAT("%s %d %d%n"),
        START_PAYMENT("## %d번 테이블의 결제를 진행합니다.%n"),
        TOTAL_PRICE("## 최종 결제할 금액\n"
                + "%d원%n");


        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

    private OutputView() {
    }
}
