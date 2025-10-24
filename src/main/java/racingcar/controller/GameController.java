package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.GameRequest;
import racingcar.service.Converter;
import racingcar.service.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Parser parser;
    private final Converter converter;

    public GameController(Parser parser, Converter converter) {
        this.parser = parser;
        this.converter = converter;
    }

    public void run() {
        GameRequest gameRequest = InputView.readValues();

        List<String> names = parser.getNames(gameRequest);
        int count = parser.getCount(gameRequest);

        List<Car> cars = converter.getCars(names);

        Game game = new Game(cars);

        for (int i = 0; i < count; i++) {
            game.play();
            OutputView.status(cars);
        }

        List<String> winners = game.getWinners();
        OutputView.result(winners);
    }
}
