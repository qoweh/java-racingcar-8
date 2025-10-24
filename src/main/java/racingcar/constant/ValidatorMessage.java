package racingcar.constant;

public enum ValidatorMessage {
    EMPTY_ENTIRE_INPUT("빈 문자열입니다."),
    EMPTY_SPECIFIC_NAME("특정 이름이 비었습니다."),
    EMPTY_EXIST("특정 이름에 공백이 존재합니다."),
    SAME_NAME_EXIST("특정 이름이 중복됩니다."),
    TOO_LONG("특정 이름이 길이(>5)를 초과했습니다."),
    INVALID_NUMBER("시도 횟수는 숫자여야 합니다."),
    NEGATIVE_NUMBER("시도 횟수는 양수여야 합니다."),
    ZERO_NUMBER("시도 횟수는 양수여야 합니다."),
    TOO_BIG("시도 횟수는 2,147,483,647 이하여야 합니다.");


    private final String message;
    private static final String NOTIFY_FORMAT = " (대상) : ";

    ValidatorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String with(String input) {
        return this.message + NOTIFY_FORMAT + input;
    }
}