package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void move() {
        this.score++;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.score, this.score);
    }
}
