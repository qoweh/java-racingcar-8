package racingcar.domain;

import java.util.List;

import racingcar.dto.GameRequest;
import racingcar.validator.InputValidator;

public class CarComponentGenerator {
    private final InputValidator inputValidator;

    public CarComponentGenerator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> namesFrom(GameRequest gameRequest) {
        String names = gameRequest.names();

        inputValidator.isNonEmptyString(names);

        List<String> splitNames = List.of(names.split(","));
        inputValidator.isValidEachName(splitNames, names);

        return splitNames;
    }

    public int countFrom(GameRequest gameRequest) {
        String count = gameRequest.count();

        inputValidator.isNonEmptyString(count);
        inputValidator.isValidNumber(count);

        int parseCount = Integer.parseInt(count);
        inputValidator.isValidSize(parseCount);

        return parseCount;
    }
}
