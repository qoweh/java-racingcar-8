package racingcar.service.validator;

import java.util.Collections;
import java.util.List;
import racingcar.constant.ValidatorMessage;

public class NamesValidator extends InputValidator {
    private static final int AS_MANY_AS_POSSIBLE = -1;

    public List<String> isValidEachNameAndGet(String originalInput) {
        List<String> splitNames = List.of(originalInput.split(",", AS_MANY_AS_POSSIBLE));
        for (String eachName : splitNames) {
            validateEmptyName(eachName, originalInput);
            validateLength(eachName);
            validateDuplicate(splitNames, eachName);
        }
        return splitNames;
    }

    private void validateEmptyName(String name, String originalNames) {
        if (name.isEmpty()) {
            consoleCleanUp();
            throw new IllegalArgumentException(
                    with(ValidatorMessage.EMPTY_SPECIFIC_NAME, originalNames)
            );
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            consoleCleanUp();
            throw new IllegalArgumentException(
                    with(ValidatorMessage.TOO_LONG, name)
            );
        }
    }

    private void validateDuplicate(List<String> names, String name) {
        if (Collections.frequency(names, name) != 1) {
            consoleCleanUp();
            throw new IllegalArgumentException(
                    with(ValidatorMessage.SAME_NAME_EXIST, name)
            );
        }
    }
}
