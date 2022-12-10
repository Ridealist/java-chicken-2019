package Validator;

import domain.MenuRepository;
import domain.TableRepository;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final List<String> VALID_MAIN_CHOICE = Arrays.asList("1","2","3");
    private static final List<String> VALID_PAY_METHOD = Arrays.asList("1","2");

    private InputValidator() {
    }

    public static void validateMainChoice(String input) {
        if (!VALID_MAIN_CHOICE.contains(input.trim())) {
            throw new IllegalArgumentException("1, 2, 3 중에 한 가지만 선택할 수 있습니다.");
        }
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    public static void validateTableNumber(int number) {
        if (!TableRepository.getTableNumbers().contains(number)) {
            throw new IllegalArgumentException("올바른 테이블 번호를 입력해주세요.");
        }
    }

    public static void validateMenuNumber(int number) {
        if (!MenuRepository.getMenuNumbers().contains(number)) {
            throw new IllegalArgumentException("올바른 메뉴를 선택해주세요.");
        }
    }

    public static void validatePayMethod(String input) {
        if (!VALID_PAY_METHOD.contains(input.trim())) {
            throw new IllegalArgumentException("올바른 결제 방법을 선택해주세요.");
        }
    }
}
