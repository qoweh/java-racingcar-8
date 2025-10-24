package racingcar.config;

import racingcar.constant.GameValue;
import racingcar.controller.GameController;
import racingcar.domain.CarComponentGenerator;
import racingcar.domain.CarGenerator;
import racingcar.domain.Game;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Rule;
import racingcar.validator.InputValidator;

public class AppConfig {
    public GameController gameController() {
        InputValidator inputValidator = new InputValidator();

        CarComponentGenerator carComponentGenerator
                = new CarComponentGenerator(inputValidator);

        CarGenerator carGenerator = new CarGenerator();

        Rule rule = new Rule(GameValue.CONDITION_NUMBER);
        RandomNumberGenerator randomNumberGenerator
                = new RandomNumberGenerator(GameValue.START_INDEX, GameValue.END_INDEX);

        Game game = new Game(rule, randomNumberGenerator);

        return new GameController(carComponentGenerator, carGenerator, game);
    }
}
