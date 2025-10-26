package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputViewMessage;

public class InputView {
    /*
     * names는 프로그램에서 첫 번째로 입력받는 값
     */
    public static String readNames() {
        System.out.println(InputViewMessage.NAME_MESSAGE);

        return Console.readLine();
    }

    /*
     * count는 프로그램에서 두 번째로 입력받는 값
     *
     * Console.close()은 Console 내부의 정적 객체 scanner를 닫는다
     * count를 입력 이후 더 이상 Console.readline()을 호출하지 않기에
     * 이 메서드에서 Console.close()를 호출한다
     */
    public static String readCount() {
        System.out.println(InputViewMessage.COUNT_MESSAGE);

        String line = Console.readLine();
        Console.close();

        return line;
    }
}
