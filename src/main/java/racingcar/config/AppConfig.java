package racingcar.config;

import racingcar.constant.GameValue;
import racingcar.controller.GameController;
import racingcar.domain.Game;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Rule;
import racingcar.service.CarComponentGenerator;
import racingcar.service.CarGenerator;
import racingcar.service.NumberValidator;
import racingcar.service.StringValidator;

public class AppConfig {
    public GameController gameController() {
        StringValidator stringValidator = new StringValidator();
        NumberValidator numberValidator = new NumberValidator();

        CarComponentGenerator carComponentGenerator
                = new CarComponentGenerator(stringValidator, numberValidator);

        CarGenerator carGenerator = new CarGenerator();

        Rule rule = new Rule(GameValue.CONDITION_NUMBER);
        RandomNumberGenerator randomNumberGenerator
                = new RandomNumberGenerator(GameValue.START_INDEX, GameValue.END_INDEX);

        Game game = new Game(rule, randomNumberGenerator);

        return new GameController(carComponentGenerator, carGenerator, game);
    }
}
