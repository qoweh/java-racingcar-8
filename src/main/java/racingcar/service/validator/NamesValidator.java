package racingcar.service.validator;

import java.util.List;
import racingcar.constant.ValidatorMessage;

public class NamesValidator extends InputValidator {
    private static final int AS_MANY_AS_POSSIBLE = -1;
    private static final int MAX_LENGTH = 5;

    public List<String> isValidAndGet(String input) {
        validateNonEmptyString(input);

        List<String> splitNames = List.of(input.split(",", AS_MANY_AS_POSSIBLE));

        for (String eachName : splitNames) {
            validateEmptyName(eachName);
            validateLength(eachName);
            validateDuplicate(splitNames, eachName);
        }

        return splitNames;
    }

    private void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throwException(ValidatorMessage.EMPTY_SPECIFIC_NAME, name);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throwException(ValidatorMessage.TOO_LONG, name);
        }
    }

    private void validateDuplicate(List<String> names, String name) {
        long count = names.stream()
                .filter(eachName -> eachName.equals(name))
                .count();
        if (count > 1) {
            throwException(ValidatorMessage.SAME_NAME_EXIST, name);
        }
    }
}
