package racingcar.service.validator;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ValidatorMessage;

public class InputValidator {
    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) {
            throwException(ValidatorMessage.EMPTY_ENTIRE_INPUT);
        }
    }

    public void throwException(String message) {
        Console.close();
        throw new IllegalArgumentException(message);
    }

    public void throwException(String message, String target) {
        Console.close();
        throw new IllegalArgumentException(with(message, target));
    }

    private String with(String message, String target) {
        return message + ValidatorMessage.NOTIFY_FORMAT + target;
    }
}
