package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;

public class Generator {
    private final NamesParser namesParser;
    private final CountParser countParser;

    public Generator(NamesParser namesParser, CountParser countParser) {
        this.namesParser = namesParser;
        this.countParser = countParser;
    }

    public Cars makeCars(String input) {
        List<String> names = namesParser.parse(input);
        return Cars.from(names);
    }

    public int makeCount(String input) {
        return countParser.parse(input);
    }
}
