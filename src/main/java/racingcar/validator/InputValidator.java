package racingcar.validator;

import java.util.Collections;
import java.util.List;

import racingcar.constant.ValidatorMessage;

public class InputValidator {
    private static final String NUMBER_TYPE = "-?\\d+";

    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) { // 빈 입력값, 공백 입력값
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
            );
        }
    }

    public void isValidEachName(List<String> splitNames, String originalNames) {
        for (String eachName : splitNames) {
            validateEmptyName(eachName, originalNames);
            validateMixedBlank(eachName);
            validateLength(eachName);
            validateDuplicate(splitNames, eachName);
        }
    }

    private void validateEmptyName(String name, String originalNames) {
        if (name.isEmpty()) { // ,n1,n2 혹은 n1,,n2
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_SPECIFIC_NAME.with(originalNames)
            );
        }
    }

    private void validateMixedBlank(String name) {
        if (name.isBlank()) {  // n1, ,n2 혹은 n1, n2 ,n3
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_EXIST.with(name)
            );
        }
    }

    private void validateLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException(
                    ValidatorMessage.TOO_LONG.with(name)
            );
        }
    }

    private void validateDuplicate(List<String> names, String name) {
        if (Collections.frequency(names, name) != 1) {
            throw new IllegalArgumentException(
                    ValidatorMessage.SAME_NAME_EXIST.with(name)
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
