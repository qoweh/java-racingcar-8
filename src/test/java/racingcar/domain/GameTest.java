package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import racingcar.view.OutputView;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game = new Game(new Rule(4), new RandomNumberGenerator(0, 9));
    List<Car> cars;

    @BeforeEach
    void beforeAll() {
        cars = new ArrayList<>();
        for (int i = 0 ; i <= 10; i++) {
            Car car = new Car("a"+String.valueOf(i), i);
            cars.add(car);
        }
    }

    @AfterEach
    void afterAll() {
        OutputView.status(cars);
    }

    @Test
    @DisplayName("우승자가 가장 큰 점수의 자동차 이름이어야 한다")
    void 승자확인1() {
        //when
        List<String> winners = game.getWinners(cars);

        //then
        assertThat(winners).contains(cars.getLast().getName());
    }

    @Test
    @DisplayName("우승자가 여러 명일 수 있다.")
    void 승자확인2() {
        //given
        cars.add(new Car("t", 10));

        //when
        List<String> winners = game.getWinners(cars);

        //then
        assertThat(winners).contains(cars.get(cars.size()-1).getName(), "t");
        assertThat(winners.size()).isEqualTo(2);
    }
}