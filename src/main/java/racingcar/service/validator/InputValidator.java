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

    public void consoleCleanUp() {
        Console.close();
    }

    public String with(String first, String second) {
        return first + ValidatorMessage.NOTIFY_FORMAT + second;
    }
}
