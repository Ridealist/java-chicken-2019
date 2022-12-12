package controller;

import java.util.Arrays;

public enum Command {
    REGISTER("1", "주문등록"),
    PAY("2", "결제하기"),
    QUIT("3", "프로그램 종료");

    private String choice;
    private String explanation;

    Command(String choice, String explanation) {
        this.choice = choice;
        this.explanation = explanation;
    }

    public static Command findCommandByInput(String input) {
        return Arrays.stream(values())
                .filter(command -> command.choice.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1, 2, 3 중에 한 가지 기능만 선택할 수 있습니다."));
    }

    @Override
    public String toString() {
        return choice + " - " + explanation;
    }
}
