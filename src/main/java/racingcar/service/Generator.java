package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Generator {
    private static final int INIT_SCORE = 0;
    private final NamesParser namesParser;
    private final CountParser countParser;

    public Generator(NamesParser namesParser, CountParser countParser) {
        this.namesParser = namesParser;
        this.countParser = countParser;
    }

    public List<Car> makeCar(String input) {
        List<String> names = namesParser.parse(input);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, INIT_SCORE);
            cars.add(car);
        }
        return cars;
    }

    public int makeCount(String input) {
        return countParser.parse(input);
    }
}
