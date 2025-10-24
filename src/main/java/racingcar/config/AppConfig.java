package racingcar.config;

import racingcar.constant.GameValue;
import racingcar.controller.GameController;
import racingcar.domain.*;
import racingcar.validator.CountValidator;
import racingcar.validator.NamesValidator;

public class AppConfig {
    public GameController gameController() {
        NamesValidator namesValidator = new NamesValidator();
        CountValidator countValidator = new CountValidator();

        CarComponentGenerator carComponentGenerator
                = new CarComponentGenerator(namesValidator, countValidator);

        CarGenerator carGenerator = new CarGenerator();

        Rule rule = new Rule(GameValue.CONDITION_NUMBER);
        RandomNumberGenerator randomNumberGenerator
                = new RandomNumberGenerator(GameValue.START_INDEX, GameValue.END_INDEX);

        Game game = new Game(rule, randomNumberGenerator);

        return new GameController(carComponentGenerator, carGenerator, game);
    }
}
