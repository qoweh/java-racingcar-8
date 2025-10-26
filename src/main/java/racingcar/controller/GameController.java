package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Winners;
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
        Cars cars = generator.makeCars(InputView.readNames());
        int count = generator.makeCount(InputView.readCount());

        OutputView.start();
        for (int i = 0; i < count; i++) {
            game.eachRoundPlay(cars);
            OutputView.status(cars);
        }

        Winners winners = game.getWinners(cars);
        OutputView.result(winners);
    }
}
