package racingcar.controller;

import racingcar.dto.GameRequest;
import racingcar.view.InputView;

public class GameController {

    public void run() {
        GameRequest gameRequest = InputView.readValues();
    }
}
