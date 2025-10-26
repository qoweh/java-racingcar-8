package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.Generator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Generator generator;
    private final Game game;

    public GameController(Generator generator, Game game) {
        this.generator = generator;
        this.game = game;
    }

    public void run() {
        List<Car> cars = generator.makeCar(InputView.readNames());
        int count = generator.makeCount(InputView.readCount());

        OutputView.gameStart();
        for (int i = 0; i < count; i++) {
            game.play(cars);
            OutputView.status(cars);
        }

        List<String> winners = game.getWinners(cars);
        OutputView.result(winners);
    }
}
