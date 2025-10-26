package racingcar.service.validator;

import racingcar.constant.ValidatorMessage;

public class CountValidator extends InputValidator {
    private static final String STRING_TYPE = "(\\s)*-?\\d+(\\s)*";

    public int isValidAndGet(String input) {
        validateNonEmptyString(input);
        validatePositiveNumeric(input);
        return validateSizeAndGet(input);
    }

    private void validatePositiveNumeric(String input) {
        if (!input.matches(STRING_TYPE)) {
            throwException(ValidatorMessage.INVALID_NUMBER, input);
        }
        if (input.contains("-")) {
            throwException(ValidatorMessage.NEGATIVE_NUMBER, input);
        }
    }

    private int validateSizeAndGet(String input) {
        int count = 0;

        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throwException(ValidatorMessage.TOO_BIG, input);
        }

        validateNotZero(count, input);

        return count;
    }

    private void validateNotZero(int number, String input) {
        if (number == 0) {
            throwException(ValidatorMessage.ZERO_NUMBER, input);
        }
    }
}