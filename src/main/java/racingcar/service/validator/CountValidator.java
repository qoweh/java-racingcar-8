package racingcar.service.validator;

import racingcar.constant.ValidatorMessage;

public class CountValidator extends InputValidator {
    private static final String NUMBER_TYPE = "(\\s)*-?\\d+(\\s)*";

    public void isValidNumberString(String input) {
        validateNumber(input);
        validatePositiveNumber(input);
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_TYPE)) {
            throw new IllegalArgumentException(
                    with(ValidatorMessage.INVALID_NUMBER, input)
            );
        }
    }

    private void validatePositiveNumber(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException(
                    with(ValidatorMessage.NEGATIVE_NUMBER, input)
            );
        }
    }

    public int isValidSizeAndGet(String input) {
        try {
            int number = Integer.parseInt(input);
            validateGreaterThanZero(input, number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    with(ValidatorMessage.TOO_BIG, String.valueOf(input))
            );
        }
    }

    private void validateGreaterThanZero(String input, int number) {
        if (number == 0) {
            throw new IllegalArgumentException(
                    with(ValidatorMessage.ZERO_NUMBER, String.valueOf(input))
            );
        }
    }
}
