package racingcar.service;

import java.util.List;
import racingcar.dto.GameRequest;
import racingcar.validator.NamesValidator;

public class NamesParser {
    private final NamesValidator namesValidator;

    public NamesParser(NamesValidator namesValidator) {
        this.namesValidator = namesValidator;
    }

    public List<String> parse(GameRequest gameRequest) {
        String names = gameRequest.names();

        namesValidator.isNonEmptyString(names);
        return namesValidator.isValidEachNameAndGet(names);
    }
}
