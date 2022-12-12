package domain.status;

import java.util.Arrays;
import util.ExceptionMessage;

public enum PaymentType {

    CARD("1"), CASH("2");

    private final String command;

    PaymentType(String command) {
        this.command = command;
    }

    public static PaymentType from(String command) {
        return Arrays.stream(PaymentType.values())
                .filter(element -> element.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_PAYMENT_TYPE.getMessage()));
    }
}
