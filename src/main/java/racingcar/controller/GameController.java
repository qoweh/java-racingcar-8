package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarGenerator;
import racingcar.domain.Game;
import racingcar.service.CarComponentGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarComponentGenerator carComponentGenerator;
    private final CarGenerator carGenerator;
    private final Game game;

    public GameController(
            CarComponentGenerator carComponentGenerator,
            CarGenerator carGenerator,
            Game game) {
        this.carComponentGenerator = carComponentGenerator;
        this.carGenerator = carGenerator;
        this.game = game;
    }

    public void run() {
        List<String> names = carComponentGenerator.namesFrom(InputView.readNames());
        int count = carComponentGenerator.countFrom(InputView.readCount());

        List<Car> cars = carGenerator.from(names);

        OutputView.gameStart();
        for (int i = 0; i < count; i++) {
            game.play(cars);
            OutputView.status(cars);
        }

        List<String> winners = game.getWinners(cars);
        OutputView.result(winners);
    }
}
