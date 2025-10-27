package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;

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

    public List<String> getMaxCarList() {
        int maxScore = getMaxScore();

        return cars.stream()
                .filter(car -> car.haveSameScore(maxScore))
                .map(Car::getName)
                .toList();
    }

    private int getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
    }

    public void forEachCar(Consumer<Car> action) {
        cars.forEach(action);
    }
}
