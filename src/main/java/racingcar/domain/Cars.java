package racingcar.domain;

import java.util.List;

public class Cars {
    private static final int INIT_SCORE = 0;
    private final List<Car> cars;

    public static Cars from(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name, INIT_SCORE))
                .toList();
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getMaxCarList() {
        int maxScore = getMaxScore();
        return cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();
    }

    private int getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
    }
}
