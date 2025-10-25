package racingcar.domain;

import java.util.List;

public class MaxScoreCalculator {
    public int score(List<Car> cars) {
        int maxScore = -1;
        for (Car car : cars) {
            if (maxScore < car.getScore()) {
                maxScore = car.getScore();
            }
        }
        return maxScore;
    }
}
