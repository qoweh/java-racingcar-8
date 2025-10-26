package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        List<String> winners = cars.getMaxCarList();
        return new Winners(winners);
    }

    public String getWinnersName() {
        return String.join(", ", winners);
    }
}
