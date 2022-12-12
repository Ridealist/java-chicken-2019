package domain.pay;

import java.util.Arrays;

public enum PayMethod {
    CREDIT_CARD(1, 1),
    CASH(2, 0.95);

    private int choice;
    private double discountPercentage;

    PayMethod(int choice, double discountPercentage) {
        this.choice = choice;
        this.discountPercentage = discountPercentage;
    }

    public static PayMethod getMethodByNumber(int number) {
        return Arrays.stream(PayMethod.values())
                .filter(payMethod -> payMethod.choice == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결제 방법은 1또는 2중에 하나를 선택해야합니다."));
    }

    public double getDiscountPrice(PayMethod payMethod, int money) {
        return payMethod.discountPercentage * money;
    }
}
