package racingcar.service;

import java.util.Collections;
import java.util.List;

import racingcar.constant.ValidatorMessage;

public class StringValidator implements Validator{
    @Override
    public void isNonEmptyString(String input) {
        if (input == null || input.isBlank()) { // 빈 입력값, 공백 입력값
            throw new IllegalArgumentException(
                    ValidatorMessage.EMPTY_ENTIRE_INPUT.with(input)
            );
        }
    }

    public void isValidEachName(List<String> splitNames, String originalNames) {
        for (String eachName : splitNames) {
            if (eachName.isEmpty()) { // ,n1,n2 혹은 n1,,n2
                throw new IllegalArgumentException(
                        ValidatorMessage.EMPTY_SPECIFIC_NAME.with(originalNames)
                );
            }
            if (eachName.isBlank()) { // n1,  ,n2 혹은 n1, n2 ,n3
                throw new IllegalArgumentException(
                        ValidatorMessage.EMPTY_EXIST.with(eachName)
                );
            }
            if (eachName.length() >= 5) {
                throw new IllegalArgumentException(
                        ValidatorMessage.TOO_LONG.with(eachName)
                );
            }
            if (Collections.frequency(splitNames, eachName) != 1) {
                throw new IllegalArgumentException(
                        ValidatorMessage.SAME_NAME_EXIST.with(eachName)
                );
            }
        }
    }

    private void is() {

    }
}
