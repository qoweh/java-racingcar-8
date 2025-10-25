package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ValidatorMessage;
import racingcar.service.validator.InputValidator;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class CountValidatorTest extends NsTest{
    private static final String SUCCESS_TYPE = "[성공 케이스] ";
    private static final String FAIL_TYPE = "[실패 케이스] ";

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {" ", "\n"})
    @DisplayName(FAIL_TYPE + "공백 문자열")
    void 잘못된_입력값1_공백_문자열(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ValidatorMessage.EMPTY_ENTIRE_INPUT)
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"", " ", "\n"})
    @DisplayName(FAIL_TYPE + "빈 문자열")
    void 잘못된_입력값1_빈_문자열(String input) {
        //given
        InputValidator inputValidator = new InputValidator();

        //when
        Throwable throwable = catchThrowable(()-> inputValidator.isNonEmptyString(input));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidatorMessage.EMPTY_ENTIRE_INPUT);
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"~12", "4!", "@23", "kim", "- 1", "1 2"})
    @DisplayName(FAIL_TYPE + "정수가 아닌 경우")
    void 잘못된_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ValidatorMessage.INVALID_NUMBER)
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"0", " 0", " 0 ", "0 "})
    @DisplayName(FAIL_TYPE + "0인 경우")
    void 잘못된_입력값3(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ValidatorMessage.ZERO_NUMBER)
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"-1", "-1 ", " -1", " -1 ", "-2147483648", "-214748364800"})
    @DisplayName(FAIL_TYPE + "음수인 경우")
    void 입력값5(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ValidatorMessage.NEGATIVE_NUMBER)
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"2147483648"})
    @DisplayName(FAIL_TYPE + "overflow 발생하는 경우")
    void 입력값6(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ValidatorMessage.TOO_BIG)
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"1", "14", "5"})
    @DisplayName(SUCCESS_TYPE + "양수인 경우")
    void 정상적인_입력값1(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> run("kim,lee", input))
        );
    }

    @Disabled
    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"2147483647"})
    @DisplayName(SUCCESS_TYPE + "int 최대값")
    void 정상적인_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> run("kim,lee", input))
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {" 1", "1  ", "  1  "})
    @DisplayName(SUCCESS_TYPE + "공백이 포함된 양수인 경우")
    void 정상적인_입력값3(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> run("kim,lee", input))
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}