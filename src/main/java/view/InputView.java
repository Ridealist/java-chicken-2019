package view;

import Validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputFunctionNumber() throws IllegalArgumentException {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static int inputTableNumber() {
        System.out.println();
        System.out.println("## 주문할 테이블을 선택하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static int inputMenuChoice() {
        System.out.println();
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static int inputMenuAmount() {
        System.out.println();
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
