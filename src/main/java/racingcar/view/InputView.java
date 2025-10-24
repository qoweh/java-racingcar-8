package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.constant.InputViewMessage;
import racingcar.dto.GameRequest;

public class InputView {
    public static GameRequest readValues() {
        String names = getNames();
        String count = getCount();
        Console.close();

        return new GameRequest(names, count);
    }

    private static String getNames() {
        System.out.println(InputViewMessage.NAME_MESSAGE);
        return Console.readLine();
    }

    private static String getCount() {
        System.out.println(InputViewMessage.COUNT_MESSAGE);
        return Console.readLine();
    }
}
