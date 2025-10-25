package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ValidatorMessage;
import racingcar.validator.InputValidator;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class CountValidatorTest extends NsTest{
    private static final String SUCCESS_TYPE = "[성공 케이스] ";
    private static final String FAIL_TYPE = "[실패 케이스] ";

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {" "})  // 빈 문자열("")은 NsTest 프레임워크 제한으로 통합 테스트 불가
    @DisplayName(FAIL_TYPE + "공백만 있는 문자열")
    void 잘못된_입력값1_공백_문자열(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
                        )
        );
    }

    @Test
    @DisplayName(FAIL_TYPE + "빈 문자열")
    void 잘못된_입력값1_빈_문자열() {
        // NsTest의 runException은 빈 문자열을 Console.readLine()에 제대로 주입하지 못함
        // 이유: 빈 문자열은 입력 스트림에서 "EOF"로 해석되어 readLine()이 호출되지 않음
        // 따라서 단위 테스트로만 검증
        
        //given
        String input = "";
        InputValidator inputValidator = new InputValidator();

        //when
        Throwable throwable = catchThrowable(()-> inputValidator.isNonEmptyString(input));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ValidatorMessage.EMPTY_ENTIRE_INPUT.getMessage()
                );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"~12", "4!", "@23", "kim", "- 1", "1 2"})
    @DisplayName(FAIL_TYPE + "정수가 아닌 경우")
    void 잘못된_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.INVALID_NUMBER.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"0", " 0", " 0 ", "0 "})
    @DisplayName(FAIL_TYPE + "0인 경우")
    void 잘못된_입력값3(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.ZERO_NUMBER.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"-1", "-1 ", " -1", " -1 ", "-2147483648", "-214748364800"})
    @DisplayName(FAIL_TYPE + "음수인 경우")
    void 입력값5(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.NEGATIVE_NUMBER.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"2147483648"})
    @DisplayName(FAIL_TYPE + "overflow 발생하는 경우")
    void 입력값6(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(
                                ValidatorMessage.TOO_BIG.getMessage()
                        )
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"1", "14", "5"})
    @DisplayName(SUCCESS_TYPE + "양수인 경우")
    void 정상적인_입력값1(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> runException("kim,lee", input))
        );
    }

    @Disabled
    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {"2147483647"})
    @DisplayName(SUCCESS_TYPE + "int 최대값")
    void 정상적인_입력값2(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> runException("kim,lee", input))
        );
    }

    @ParameterizedTest(name = "입력값:{0}")
    @ValueSource(strings = {" 1", "1  ", "  1  "})
    @DisplayName(SUCCESS_TYPE + "공백이 포함된 양수인 경우")
    void 정상적인_입력값3(String input) {
        assertSimpleTest(() ->
                assertThatCode(() -> runException("kim,lee", input))
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}