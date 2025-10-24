package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class CarGenerator {
    private static final int INIT_SCORE = 0;

    public List<Car> from(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, INIT_SCORE);
            cars.add(car);
        }
        return cars;
    }
}
