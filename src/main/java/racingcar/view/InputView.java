package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputViewMessage;

public class InputView {
    /*
     * names는 프로그램에서 첫 번째로 입력받는 값
     *
     * Console.close()은 Console의 정적 변수 scanner를 닫기에,
     * names의 유효성 검사 중 예외가 발생하여 프로그래밍이 종료될 때, 혹은
     * count를 입력받고 난 후에 호출한다.
     */
    public static String readNames() {
        System.out.println(InputViewMessage.NAME_MESSAGE);

        return Console.readLine();
    }

    /*
     * count는 프로그램에서 두 번째로 입력받는 값
     */
    public static String readCount() {
        System.out.println(InputViewMessage.COUNT_MESSAGE);

        String line = Console.readLine();
        Console.close();

        return line;
    }
}
