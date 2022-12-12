package util.validator;

import java.util.regex.Pattern;
import util.ExceptionMessage;

public class MenuQuantityValidator extends Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
        validateNumberRange(input);
    }

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage(), exception);
        }
    }

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number > Range.MAX_RANGE.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage());
        }
    }

    private enum Range {
        MAX_RANGE(99);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}
