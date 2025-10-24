package racingcar.service;

import racingcar.constant.ValidatorMessage;

public class NumberValidator implements Validator {
    private static final String NUMBER_TYPE = "-?\\d+";

    @Override
    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) { // 빈 입력값, 공백 입력값
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
            );
        }
    }

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
            int numberPlusOne = Math.addExact(number, 1);
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
