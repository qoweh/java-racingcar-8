package racingcar.service;

import java.util.List;

public class CarComponentGenerator {
    private final NamesParser namesParser;
    private final CountParser countParser;

    public CarComponentGenerator(NamesParser namesParser, CountParser countParser) {
        this.namesParser = namesParser;
        this.countParser = countParser;
    }

    public List<String> namesFrom(String input) {
        return namesParser.parse(input);
    }

    public int countFrom(String  input) {
        return countParser.parse(input);
    }
}
