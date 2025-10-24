package racingcar;

import racingcar.controller.GameController;
import racingcar.service.Converter;
import racingcar.service.NumberValidator;
import racingcar.service.Parser;
import racingcar.service.StringValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringValidator stringValidator = new StringValidator();
        NumberValidator numberValidator = new NumberValidator();
        Parser parser = new Parser(stringValidator, numberValidator);

        Converter converter = new Converter();

        GameController gameController = new GameController(parser, converter);
        gameController.run();
    }
}
