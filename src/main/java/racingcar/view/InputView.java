package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.constant.InputViewMessage;
import racingcar.dto.GameRequest;

public class InputView {
    public static GameRequest readValues() {
        String names = readNames();
        String count = readCount();
        Console.close();

        return new GameRequest(names, count);
    }

    private static String readNames() {
        System.out.println(InputViewMessage.NAME_MESSAGE);
        return Console.readLine();
    }

    private static String readCount() {
        System.out.println(InputViewMessage.COUNT_MESSAGE);
        return Console.readLine();
    }
}
