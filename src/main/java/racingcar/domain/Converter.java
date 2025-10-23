package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private final List<String> names;
    private static final int INIT_SCORE = 0;

    public Converter(List<String> names) {
        this.names = names;
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, INIT_SCORE);
            cars.add(car);
        }
        return cars;
    }
}
