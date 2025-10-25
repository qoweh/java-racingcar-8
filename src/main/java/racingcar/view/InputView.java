package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputViewMessage;

public class InputView {
    public static String readNames() {
        System.out.println(InputViewMessage.NAME_MESSAGE);
        return Console.readLine();
    }

    public static String readCount() {
        System.out.println(InputViewMessage.COUNT_MESSAGE);
        String line = Console.readLine();
        Console.close();
        return line;
    }
}
