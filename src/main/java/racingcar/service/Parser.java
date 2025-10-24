package racingcar.service;

import java.util.List;

import racingcar.dto.GameRequest;

public class Parser {
    private final StringValidator stringValidator;
    private final NumberValidator numberValidator;

    public Parser(StringValidator stringValidator, NumberValidator numberValidator) {
        this.stringValidator = stringValidator;
        this.numberValidator = numberValidator;
    }

    public List<String> getNames(GameRequest gameRequest) {
        String names = gameRequest.names();

        stringValidator.isNonEmptyString(names);

        List<String> splitNames = List.of(names.split(","));
        stringValidator.isValidEachName(splitNames, names);

        return splitNames;
    }

    public int getCount(GameRequest gameRequest) {
        String count = gameRequest.count();

        numberValidator.isNonEmptyString(count);
        numberValidator.isValidNumber(count);

        int parseCount = Integer.parseInt(count);
        numberValidator.isValidSize(parseCount);

        return parseCount;
    }
}
