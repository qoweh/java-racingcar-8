package racingcar.service;

import java.util.Collections;
import java.util.List;
import racingcar.dto.GameRequest;

public class Parser {
    private final String names;
    private final String count;
    private static final String MESSAGE_EMPTY_ENTIRE_INPUT = "빈 문자열입니다.";
    private static final String MESSAGE_EMPTY_SPECIFIC_NAME = "특정 이름이 비었습니다. (전체 문자열) : ";
    private static final String MESSAGE_EMPTY_EXIST = "특정 이름에 공백이 존재합니다. (특정 문자열) : ";
    private static final String MESSAGE_SAME_NAME_EXIST = "특정 이름이 중복됩니다. (특정 문자열) : ";
    private static final String MESSAGE_TOO_LONG = "특정 이름이 길이(>5)를 초과했습니다. (특정 문자열) : ";
    private static final String MESSAGE_INVALID_NUMBER_FORAMT = "시도 횟수는 숫자여야 합니다. (시도 횟수) : ";
    private static final String MESSAGE_TOO_SMALL = "시도 횟수는 1 이상이어야 합니다. (시도 횟수) : ";
    private static final String MESSAGE_TOO_BIG = "시도 횟수는 2,147,483,647 이하여야 합니다. (시도 횟수) : ";

    public Parser(GameRequest gameRequest) {
        this.names = gameRequest.names();
        this.count = gameRequest.count();
    }

    public List<String> getNames() {
        validateString(this.names);

        List<String> splitNames = List.of(this.names.split(","));
        validateSplitNames(splitNames);

        return splitNames;
    }

    private void validateString(String input) {
        if (input == null || input.isBlank()) { // 빈 입력값, 공백 입력값
            throw new IllegalArgumentException(MESSAGE_EMPTY_ENTIRE_INPUT);
        }
    }

    private void validateSplitNames(List<String> splitNames) {
        for (String name : splitNames) {
            if (name.isEmpty()) { // ,n1,n2 혹은 n1,,n2
                throw new IllegalArgumentException(MESSAGE_EMPTY_SPECIFIC_NAME + this.names);
            }
            if (name.isBlank()) { // n1,  ,n2 혹은 n1, n2 ,n3
                throw new IllegalArgumentException(MESSAGE_EMPTY_EXIST + name);
            }
            if (name.length() >= 5) {
                throw new IllegalArgumentException(MESSAGE_TOO_LONG + name);
            }
            if (Collections.frequency(splitNames, name) != 1) {
                throw new IllegalArgumentException(MESSAGE_SAME_NAME_EXIST + name);
            }
        }
    }

    public int getCount() {
        validateString(this.count);
        try {
            long parseCount = Long.parseLong(this.count);
            validateCount(parseCount);
            return (int) parseCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_INVALID_NUMBER_FORAMT + this.count);
        }
    }

    private void validateCount(long parseCount) {
        if (parseCount <= 0) {
            throw new IllegalArgumentException(MESSAGE_TOO_SMALL + parseCount);
        } else if (parseCount >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(MESSAGE_TOO_BIG + parseCount);
        }
    }
}
