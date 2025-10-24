package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.GameRequest;
import racingcar.service.CarComponentGenerator;
import racingcar.service.CarGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarComponentGenerator carComponentGenerator;
    private final CarGenerator carGenerator;
    private final Game game;

    public GameController(CarComponentGenerator carComponentGenerator, CarGenerator carGenerator, Game game) {
        this.carComponentGenerator = carComponentGenerator;
        this.carGenerator = carGenerator;
        this.game = game;
    }

    public void run() {
        GameRequest gameRequest = InputView.readValues();

        List<String> names = carComponentGenerator.namesFrom(gameRequest);
        int count = carComponentGenerator.countFrom(gameRequest);

        List<Car> cars = carGenerator.from(names);

        for (int i = 0; i < count; i++) {
            game.play(cars);
            OutputView.status(cars);
        }

        List<String> winners = game.getWinners(cars);
        OutputView.result(winners);
    }
}
