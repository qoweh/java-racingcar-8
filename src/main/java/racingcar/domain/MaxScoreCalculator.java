package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class MaxScoreCalculator {
    public void sort(List<Car> cars) {
        Collections.sort(cars);
    }

    public int score(List<Car> cars) {
        return cars.getFirst().getScore();
    }
}
