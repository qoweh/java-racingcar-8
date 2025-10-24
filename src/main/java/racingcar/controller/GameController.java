package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.Converter;
import racingcar.domain.Game;
import racingcar.service.Parser;
import racingcar.dto.GameRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {


    public void run() {
        GameRequest gameRequest = InputView.readValues();

        Parser parser = new Parser(gameRequest);
        List<String> names = parser.getNames();
        int count = parser.getCount();

        Converter converter = new Converter(names);
        List<Car> cars = converter.getCars();

        Game game = new Game(cars);

        for (int i = 0; i < count; i++) {
            game.play();
            OutputView.status(cars);
        }

        List<String> winners = game.getWinners();
        OutputView.result(winners);
    }
}
