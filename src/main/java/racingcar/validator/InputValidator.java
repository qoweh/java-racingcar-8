package racingcar.validator;

import racingcar.constant.ValidatorMessage;

public class InputValidator {
    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) { // 빈 입력값, 공백 입력값
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
            );
        }
    }
}
