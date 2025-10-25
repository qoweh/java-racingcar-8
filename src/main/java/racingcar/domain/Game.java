package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Rule rule;
    private final RandomNumberGenerator randomNumberGenerator;
    private final MaxScoreCalculator maxScoreCalculator;

    public Game(Rule rule, RandomNumberGenerator randomNumberGenerator) {
        this.rule = rule;
        this.randomNumberGenerator = randomNumberGenerator;
        this.maxScoreCalculator = new MaxScoreCalculator();
    }

    public void play(List<Car> cars) {
        for (Car car : cars) {
            int number = randomNumberGenerator.generate();
            if (rule.valid(number)) {
                car.move();
            }
        }
    }

    public List<String> getWinners(List<Car> cars) {
        int maxScore = maxScoreCalculator.score(cars);
        return getWinnersName(cars, maxScore);
    }

    private List<String> getWinnersName(List<Car> cars, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getScore() < maxScore) {
                continue;
            }
            winners.add(car.getName());
        }
        return winners;
    }
}
