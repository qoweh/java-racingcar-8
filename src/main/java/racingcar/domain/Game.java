package racingcar.domain;

import java.util.List;

public class Game {
    private final Rule rule;
    private final RandomNumberGenerator randomNumberGenerator;

    public Game(Rule rule, RandomNumberGenerator randomNumberGenerator) {
        this.rule = rule;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void eachRoundPlay(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(this::eachRoundCarPlay);
    }

    private void eachRoundCarPlay(Car car) {
        int number = randomNumberGenerator.generate();
        if (rule.valid(number)) {
            car.move();
        }
    }

    public Winners getWinners(Cars cars) {
        return Winners.from(cars);
    }
}
