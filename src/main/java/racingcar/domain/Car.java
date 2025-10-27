package racingcar.domain;

public class Car {
    private final String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public boolean haveSameScore(int score) {
        return this.score == score;
    }

    public boolean isGreaterThan(int score) {
        return this.score > score;
    }

    public String makeCustomStringsOf(String dash) {
        return dash.repeat(this.score);
    }
    public void move() {
        this.score++;
    }
}
