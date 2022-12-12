package view;

import domain.Menu;
import domain.Table;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public void printMainScreen() {
        System.out.println(Message.MAIN_SCREEN.message);
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

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }


    private enum Message {
        MAIN_SCREEN("## 메인화면\n"
                + "1 - 주문등록\n"
                + "2 - 결제하기\n"
                + "3 - 프로그램 종료");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
