package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {

    public static int inputFunctionNumber() throws IllegalArgumentException {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        return validateNumber(input);
    }

    public static int inputTableNumber() throws IllegalArgumentException {
        System.out.println("## 테이블을 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        return validateNumber(input);
    }

    public static int inputMenuChoice() throws IllegalArgumentException {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        return validateNumber(input);
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String input = breakOneLineAfterRead(Console::readLine);
        return validateNumber(input);
    }

    public static int inputPayMethod() {
        System.out.println("## 신용 카드는 1번. 현금은 2번");
        String input = breakOneLineAfterRead(Console::readLine);
        return validateNumber(input);
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다. 올바른 숫자를 입력해주세요.");
        }
    }

    private static <T> T breakOneLineAfterRead(Supplier<T> reader) {
        T input = reader.get();
        System.out.println();
        return input;
    }
}
