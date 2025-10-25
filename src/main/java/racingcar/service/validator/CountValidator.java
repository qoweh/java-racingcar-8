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
                    ValidatorMessage.INVALID_NUMBER.with(input)
            );
        }
    }

    private void validatePositiveNumber(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException(
                    ValidatorMessage.NEGATIVE_NUMBER.with(input)
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
                    ValidatorMessage.TOO_BIG.with(String.valueOf(input))
            );
        }
    }

    private void validateGreaterThanZero(String input, int number) {
        if (number == 0) {
            throw new IllegalArgumentException(
                    ValidatorMessage.ZERO_NUMBER.with(String.valueOf(input))
            );
        }
    }
}
