package controller;

import java.util.Arrays;

public enum Command {
    REGISTER(1, "주문등록"),
    PAY(2, "결제하기"),
    QUIT(3, "프로그램 종료");

    private int choice;
    private String explanation;

    Command(int choice, String explanation) {
        this.choice = choice;
        this.explanation = explanation;
    }

    public static Command findCommandByNumber(int number) {
        return Arrays.stream(values())
                .filter(command -> command.choice == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1, 2, 3 중에 한 가지 기능만 선택할 수 있습니다."));
    }

    @Override
    public String toString() {
        return choice + " - " + explanation;
    }
}
