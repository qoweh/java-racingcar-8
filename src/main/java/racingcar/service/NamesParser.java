package racingcar.service;

import java.util.List;
import racingcar.service.validator.NamesValidator;

public class NamesParser {
    private final NamesValidator namesValidator;

    public NamesParser(NamesValidator namesValidator) {
        this.namesValidator = namesValidator;
    }

    public List<String> parse(String input) {
        namesValidator.isNonEmptyString(input);
        return namesValidator.isValidEachNameAndGet(input);
    }
}
