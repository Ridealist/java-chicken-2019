package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Menu;
import domain.MenuRepository;
import domain.status.MainOption;
import java.util.Scanner;
import util.Util;
import util.validator.MenuQuantityValidator;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(Message.SELECT_TABLE.message);
        return scanner.nextInt();
    }

    public static MainOption readMainOption() {
        System.out.println(Message.SELECT_MAIN_OPTION.message);
        return MainOption.from(Util.removeSpace(Console.readLine()));
    }

    public static Menu readMenu() {
        System.out.println(Message.SELECT_MENU.message);
        return MenuRepository.from(Util.removeSpace(Console.readLine()));
    }

    public static int readMenuQuantity() {
        System.out.println(Message.SELECT_MENU_QUANTITY.message);
        String input = Util.removeSpace(Console.readLine());
        new MenuQuantityValidator().validate(input);
        return Integer.parseInt(input);
    }

    private enum Message {
        SELECT_TABLE("## 주문할 테이블을 선택하세요."),
        SELECT_MAIN_OPTION("## 원하는 기능을 선택하세요."),
        SELECT_MENU("## 등록할 메뉴를 선택하세요."),
        SELECT_MENU_QUANTITY("## 메뉴의 수량을 입력하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
;