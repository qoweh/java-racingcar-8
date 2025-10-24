package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.constant.GameValue;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private final List<Car> cars;
    private final Rule rule;

    public Game(List<Car> cars) {
        this.cars = cars;
        this.rule = new Rule(GameValue.CONDITION_NUMBER.getValue());
    }

    public void play() {
        for (Car car : this.cars) {
            int number = makeNumber();
            if (this.rule.valid(number)) {
                car.move();
            }
        }
    }

    private int makeNumber() {
        return pickNumberInRange(
                GameValue.START_INDEX.getValue(),
                GameValue.END_INDEX.getValue()
        );
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        int maxScore = getMaxScore();

        for (Car car : this.cars) {
            if (car.getScore() < maxScore) {
                break;
            }
            winners.add(car.getName());
        }

        return winners;
    }

    private int getMaxScore() {
        Collections.sort(this.cars);
        return this.cars.getFirst().getScore();
    }
}
