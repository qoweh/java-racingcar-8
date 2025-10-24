package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    private final int start;
    private final int end;

    public RandomNumberGenerator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int generate() {
        return pickNumberInRange(start, end);
    }
}
