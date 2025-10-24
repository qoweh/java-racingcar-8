package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.dto.GameRequest;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static GameRequest readValues() {
        String names = getNames();
        String count = getCount();
        Console.close();

        return new GameRequest(names, count);
    }

    private static String getNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return Console.readLine();
    }

    private static String getCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        return Console.readLine();
    }
}
