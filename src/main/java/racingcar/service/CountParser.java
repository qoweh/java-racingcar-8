package racingcar.service;

import racingcar.service.validator.CountValidator;

public class CountParser {
    private final CountValidator countValidator;

    public CountParser(CountValidator countValidator) {
        this.countValidator = countValidator;
    }

    public int parse(String input) {
        String count = input.trim();

        return countValidator.isValidAndGet(count);
    }

}
