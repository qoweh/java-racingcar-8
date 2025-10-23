package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private final List<Car> cars;
    private final Rule rule;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 9;
    private static final int CONDITION_NUMBER = 4;

    public Game(List<Car> cars) {
        this.cars = cars;
        rule = new Rule(CONDITION_NUMBER);
    }

    public void play() {
        for (Car car : cars) {
            int conditionNumber = makeConditionNumber();
            if (rule.valid(conditionNumber)) {
                car.move();
            }
        }
    }

    private int makeConditionNumber() {
        return pickNumberInRange(START_INDEX, END_INDEX);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        int maxScore = getMaxScore();

        for (Car car : cars) {
            if (car.getScore() < maxScore) {
                break;
            }
            winners.add(car.getName());
        }

        return winners;
    }

    private int getMaxScore() {
        Collections.sort(cars);
        return cars.get(0).getScore();
    }
}
