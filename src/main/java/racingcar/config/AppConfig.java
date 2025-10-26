package racingcar.config;

import racingcar.constant.GameValue;
import racingcar.controller.GameController;
import racingcar.domain.Game;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Rule;
import racingcar.service.CountParser;
import racingcar.service.Generator;
import racingcar.service.NamesParser;
import racingcar.service.validator.CountValidator;
import racingcar.service.validator.NamesValidator;

public class AppConfig {
    public GameController gameController() {
        NamesValidator namesValidator = new NamesValidator();
        NamesParser namesParser = new NamesParser(namesValidator);

        CountValidator countValidator = new CountValidator();
        CountParser countParser = new CountParser(countValidator);

        Generator generator = new Generator(namesParser, countParser);

        Rule rule = new Rule(GameValue.CONDITION_NUMBER);
        RandomNumberGenerator randomNumberGenerator
                = new RandomNumberGenerator(GameValue.START_INDEX, GameValue.END_INDEX);

        Game game = new Game(rule, randomNumberGenerator);

        return new GameController(generator, game);
    }
}
