package racingcar.validator;

import java.util.Collections;
import java.util.List;
import racingcar.constant.ValidatorMessage;

public class NamesValidator extends InputValidator {
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
}
