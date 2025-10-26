package racingcar.service.validator;

import java.util.List;
import racingcar.constant.ValidatorMessage;

public class NamesValidator extends InputValidator {
    private static final int AS_MANY_AS_POSSIBLE = -1;
    private static final int MAX_LENGTH = 5;

    public List<String> isValidEachNameAndGet(String input) {
        List<String> splitNames = List.of(input.split(",", AS_MANY_AS_POSSIBLE));
        for (String eachName : splitNames) {
            validateEmptyName(eachName, input);
            validateLength(eachName);
            validateDuplicate(splitNames, eachName);
        }
        return splitNames;
    }

    private void validateEmptyName(String name, String input) {
        if (name.isEmpty()) {
            throwExceptionWithCleanUp(ValidatorMessage.EMPTY_SPECIFIC_NAME, input);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throwExceptionWithCleanUp(ValidatorMessage.TOO_LONG, name);
        }
    }

    private void validateDuplicate(List<String> names, String name) {
        long count = names.stream()
                .filter(eachName -> eachName.equals(name))
                .count();
        if (count > 1) {
            throwExceptionWithCleanUp(ValidatorMessage.SAME_NAME_EXIST, name);
        }
    }
}
