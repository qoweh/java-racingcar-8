package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ValidatorMessage;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringValidatorTest extends NsTest{
    private static final String SUCCESS_TYPE = "[성공 케이스] ";
    private static final String FAIL_TYPE = "[실패 케이스] ";

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"", " ", "\n"})
    @DisplayName(FAIL_TYPE + "빈 문자열")
    void 잘못된_입력값1(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"kim,,,park", ",,,kim,park", "kim,park,,,"})
    @DisplayName(FAIL_TYPE + "누락된 이름 존재")
    void 잘못된_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.EMPTY_SPECIFIC_NAME.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"123456,kim", "12345 ,kim", "lee, 12345", "      ,lee"})
    @DisplayName(FAIL_TYPE + "길이가 6 이상인 이름 존재")
    void 잘못된_입력값3(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.TOO_LONG.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"kim,kim,lee", " , ,kim"})
    @DisplayName(FAIL_TYPE + "중복된 이름 존재")
    void 입력값5(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.SAME_NAME_EXIST.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"kim, lee,park", " kim ,lee,park "})
    @DisplayName(SUCCESS_TYPE + "공백이 포함된 이름 존재")
    void 정상적인_입력값1(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> run(input, "1"))
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"kim, kim,lee", " 1,1 ,kim"})
    @DisplayName(SUCCESS_TYPE + "중복된 것처럼 보이는 이름 존재")
    void 정상적인_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> run(input, "1"))
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}