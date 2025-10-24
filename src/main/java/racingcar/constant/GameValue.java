package racingcar.constant;

public enum GameValue {
    START_INDEX(0),
    END_INDEX(9),
    CONDITION_NUMBER(4);

    private final int value;

    GameValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
