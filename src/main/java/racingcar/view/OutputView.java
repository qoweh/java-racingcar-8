package racingcar.view;

import java.util.List;
import racingcar.constant.OutputViewMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static void start() {
        System.out.println(OutputViewMessage.STATUS_MESSAGE);
    }

    public static void status(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(OutputView::eachCarStatus);

        System.out.println();
    }

    private static void eachCarStatus(Car car) {
        String name = car.getName();
        int score = car.getScore();
        String scorePrint = OutputViewMessage.SCORE_SYMBOL.repeat(score);

        System.out.println(name + OutputViewMessage.STATUS_SYMBOL + scorePrint);
    }

    public static void result(Winners winners) {
        String result = winners.getWinnersName();

        System.out.println(OutputViewMessage.RESULT_MESSAGE + result);
    }
}
