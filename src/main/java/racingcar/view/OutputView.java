package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    private static boolean firstPrint = true;
    private static final String OUTPUT_STATUS_MESSAGE = "\n실행 결과";
    private static final String OUTPUT_SCORE_LOG = "-";
    private static final String OUTPUT_STATUS_FORMAT = " : ";
    private static final String OUTPUT_RESULT_MESSAGE = "최종 우승자 : ";

    public static void status(List<Car> cars) {
        printResultFormat();

        for (Car car : cars) {
            eachCarStatus(car);
        }

        System.out.println();
    }

    private static void printResultFormat() {
        if (firstPrint) {
            System.out.println(OUTPUT_STATUS_MESSAGE);
            firstPrint = false;
        }
    }

    private static void eachCarStatus(Car car) {
        String name = car.getName();

        int score = car.getScore();
        String scoreLog = OUTPUT_SCORE_LOG.repeat(score);

        System.out.println(name + OUTPUT_STATUS_FORMAT + scoreLog);
    }

    public static void result(List<String> names) {
        String result = joinString(names);

        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }

    private static String joinString(List<String> names) {
        if (names.size() == 1) {
            return names.get(0);
        }

        return String.join(", ", names);
    }
}
