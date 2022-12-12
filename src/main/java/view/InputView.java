package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Menu;
import domain.MenuRepository;
import domain.status.MainOption;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static MainOption readMainOption() {
        System.out.println(Message.SELECT_MAIN_OPTION.message);
        return MainOption.from(Console.readLine());
    }

    public static Menu readMenu() {
        System.out.println(Message.SELECT_MENU.message);
        return MenuRepository.from(Console.readLine());
    }

    private enum Message {
        SELECT_MAIN_OPTION("## 원하는 기능을 선택하세요."),
        SELECT_MENU("## 등록할 메뉴를 선택하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
;