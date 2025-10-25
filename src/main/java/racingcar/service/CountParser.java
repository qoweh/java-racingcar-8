package racingcar.service;

import racingcar.dto.GameRequest;
import racingcar.validator.CountValidator;

public class CountParser {
    private final CountValidator countValidator;

    public CountParser(CountValidator countValidator) {
        this.countValidator = countValidator;
    }

    public int parse(GameRequest gameRequest) {
        String countBeforeTrim = gameRequest.count();
        String count = countBeforeTrim.trim();

        countValidator.isNonEmptyString(count);
        countValidator.isValidNumberString(count);
        return countValidator.isValidSizeAndGet(count);
    }

}
