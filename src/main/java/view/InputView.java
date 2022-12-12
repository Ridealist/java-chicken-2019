package view;

import Validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {

    public static int inputFunctionNumber() throws IllegalArgumentException {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        InputValidator.validateMainChoice(input);
        return Integer.parseInt(input);
    }

    public static int inputTableNumber() throws IllegalArgumentException {
        System.out.println("## 테이블을 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        int number = InputValidator.validateNumber(input);
        // TODO DB 단에서 레코드가 있는지 확인하는 것을 InputView에서 진행해도 되는가...?
        InputValidator.validateTableNumber(number);
        return number;
    }

    public static int inputMenuChoice() throws IllegalArgumentException {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        int number = InputValidator.validateNumber(input);
        InputValidator.validateMenuNumber(number);
        return number;
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        return InputValidator.validateNumber(input);
    }

    public static int inputPayMethod() {
        System.out.println("## 신용 카드는 1번. 현금은 2번");
        String input = breakOneLineAfterRead(Console::readLine);
        InputValidator.validatePayMethod(input);
        return Integer.parseInt(input);
    }

    private static <T> T breakOneLineAfterRead(Supplier<T> reader) {
        T input = reader.get();
        System.out.println();
        return input;
    }
}
