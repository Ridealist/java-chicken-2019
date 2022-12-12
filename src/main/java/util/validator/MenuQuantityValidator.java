package util.validator;

public class MenuQuantityValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
        validateNumberRange(input);
    }
}
