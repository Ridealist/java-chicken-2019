package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import util.ExceptionMessage;

public enum PaymentType {

    CARD("1", new BigDecimal("1")),
    CASH("2", new BigDecimal("0.95"));

    private final String command;
    private final BigDecimal discountRate;

    PaymentType(String command, BigDecimal discountRate) {
        this.command = command;
        this.discountRate = discountRate;
    }

    public static PaymentType from(String command) {
        return Arrays.stream(PaymentType.values())
                .filter(element -> element.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_PAYMENT_TYPE.getMessage()));
    }
    public BigDecimal getDiscountRate() {
        return discountRate;
    }
}
