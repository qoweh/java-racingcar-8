package racingcar.domain;

import java.util.List;
import racingcar.dto.GameRequest;
import racingcar.validator.CountValidator;
import racingcar.validator.NamesValidator;

public class CarComponentGenerator {
    private final NamesValidator namesValidator;
    private final CountValidator countValidator;

    public CarComponentGenerator(NamesValidator namesValidator, CountValidator countValidator) {
        this.namesValidator = namesValidator;
        this.countValidator = countValidator;
    }

    public List<String> namesFrom(GameRequest gameRequest) {
        String names = gameRequest.names();

        namesValidator.isNonEmptyString(names);

        List<String> splitNames = List.of(names.split(","));
        namesValidator.isValidEachName(splitNames, names);

        return splitNames;
    }

    public int countFrom(GameRequest gameRequest) {
        String count = gameRequest.count();

        countValidator.isNonEmptyString(count);
        countValidator.isValidNumber(count);

        int parseCount = Integer.parseInt(count);
        countValidator.isValidSize(parseCount);

        return parseCount;
    }
}
