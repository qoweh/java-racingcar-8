package racingcar.service;

import java.util.List;
import racingcar.dto.GameRequest;

public class CarComponentGenerator {
    private final NamesParser namesParser;
    private final CountParser countParser;

    public CarComponentGenerator(NamesParser namesParser, CountParser countParser) {
        this.namesParser = namesParser;
        this.countParser = countParser;
    }

    public List<String> namesFrom(GameRequest gameRequest) {
        return namesParser.parse(gameRequest);
    }

    public int countFrom(GameRequest gameRequest) {
        return countParser.parse(gameRequest);
    }
}
