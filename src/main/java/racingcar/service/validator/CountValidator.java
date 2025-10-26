package racingcar.service.validator;

import racingcar.constant.ValidatorMessage;

public class CountValidator extends InputValidator {
    private static final String NUMBER_TYPE = "(\\s)*-?\\d+(\\s)*";
    private static final int UNREACHABLE = -1;

    public void isValidNumberString(String input) {
        validateNumber(input);
        validatePositiveNumber(input);
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_TYPE)) {
            throwException(ValidatorMessage.INVALID_NUMBER, input);
        }
    }

    private void validatePositiveNumber(String input) {
        if (input.contains("-")) {
            throwException(ValidatorMessage.NEGATIVE_NUMBER, input);
        }
    }

    public int isValidSizeAndGet(String input) {
        try {
            int number = Integer.parseInt(input);
            validateGreaterThanZero(input, number);
            return number;
        } catch (NumberFormatException e) {
            throwException(ValidatorMessage.TOO_BIG, input);
        }
        return UNREACHABLE;
    }

    private void validateGreaterThanZero(String input, int number) {
        if (number == 0) {
            throwException(ValidatorMessage.ZERO_NUMBER, input);
        }
    }
}
