package racingcar.service.validator;

import java.util.Collections;
import java.util.List;
import racingcar.constant.ValidatorMessage;

public class NamesValidator extends InputValidator {
    private static final int AS_MANY_AS_POSSIBLE = -1;
    private static final String BLANK = " ";

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
                    ValidatorMessage.EMPTY_SPECIFIC_NAME.with(originalNames)
            );
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            consoleCleanUp();
            throw new IllegalArgumentException(
                    ValidatorMessage.TOO_LONG.with(name)
            );
        }
    }

    private void validateDuplicate(List<String> names, String name) {
        if (Collections.frequency(names, name) != 1) {
            consoleCleanUp();
            throw new IllegalArgumentException(
                    ValidatorMessage.SAME_NAME_EXIST.with(name)
            );
        }
    }
}
