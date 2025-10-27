package racingcar.view;

import racingcar.constant.OutputViewMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static void start() {
        System.out.println(OutputViewMessage.STATUS_MESSAGE);
    }

    public static void status(Cars cars) {
        cars.forEachCar(OutputView::eachCarStatus);

        System.out.println();
    }

    private static void eachCarStatus(Car car) {
        String name = car.getName();
        String scoreStrings = car.makeCustomStringsOf(OutputViewMessage.SCORE_SYMBOL);

        System.out.println(name + OutputViewMessage.STATUS_SYMBOL + scoreStrings);
    }

    public static void result(Winners winners) {
        String result = winners.getWinnersName();

        System.out.println(OutputViewMessage.RESULT_MESSAGE + result);
    }
}
