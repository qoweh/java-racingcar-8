package racingcar.validator;

import racingcar.constant.ValidatorMessage;

public class CountValidator extends InputValidator {
    private static final String NUMBER_TYPE = "-?\\d+";

    public void isValidNumber(String input) {
        if (!input.matches(NUMBER_TYPE)) {
            throw new IllegalArgumentException(
                    ValidatorMessage.INVALID_NUMBER.with(input)
            );
        }
        if (input.contains("-")) {
            throw new IllegalArgumentException(
                    ValidatorMessage.NEGATIVE_NUMBER.with(input)
            );
        }
    }

    public void isValidSize(int number) {
        try {
            Math.addExact(number, 1);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(
                    ValidatorMessage.TOO_BIG.with(String.valueOf(number))
            );
        }
        if (number == 0) {
            throw new IllegalArgumentException(
                    ValidatorMessage.ZERO_NUMBER.with(String.valueOf(number))
            );
        }
    }
}
