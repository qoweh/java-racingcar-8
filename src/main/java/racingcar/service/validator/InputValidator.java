package racingcar.service.validator;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ValidatorMessage;

public class InputValidator {
    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) {
            consoleCleanUp();
            throw new IllegalArgumentException(ValidatorMessage.EMPTY_ENTIRE_INPUT);
        }
    }

    private void consoleCleanUp() {
        Console.close();
    }

    public void throwException(String message, String target) {
        throw new IllegalArgumentException(with(message, target));
    }

    private String with(String message, String second) {
        return message + ValidatorMessage.NOTIFY_FORMAT + second;
    }

    public void throwExceptionWithCleanUp(String message, String target) {
        consoleCleanUp();
        throwException(message, target);
    }
}
