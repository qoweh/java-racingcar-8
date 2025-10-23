package racingcar.domain;

public class Rule {
    private final int conditionValue;

    public Rule(int conditionValue) {
        this.conditionValue = conditionValue;
    }

    public boolean valid(int value) {
        return value > conditionValue;
    }
}
