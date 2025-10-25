package racingcar.view;

import java.util.List;

import racingcar.constant.OutputViewMessage;
import racingcar.domain.Car;

public class OutputView {
    public static void gameStart() {
        System.out.println(OutputViewMessage.STATUS_MESSAGE);
    }

    public static void status(List<Car> cars) {
        for (Car car : cars) {
            eachCarStatus(car);
        }

        System.out.println();
    }

    private static void eachCarStatus(Car car) {
        String name = car.getName();

        int score = car.getScore();
        String scoreLog = OutputViewMessage.SCORE_SYMBOL.repeat(score);

        System.out.println(name + OutputViewMessage.STATUS_SYMBOL + scoreLog);
    }

    public static void result(List<String> names) {
        String result = joinString(names);

        System.out.println(OutputViewMessage.RESULT_MESSAGE + result);
    }

    private static String joinString(List<String> names) {
        if (names.size() == 1) {
            return names.getFirst();
        }

        return String.join(", ", names);
    }
}
