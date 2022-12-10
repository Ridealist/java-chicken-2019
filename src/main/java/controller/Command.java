package controller;

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

    @Override
    public String toString() {
        return choice + " - " + explanation;
    }
}
