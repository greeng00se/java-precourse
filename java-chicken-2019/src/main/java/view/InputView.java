package view;

import camp.nextstep.edu.missionutils.Console;
import command.FrontCommand;

public enum InputView {
    INSTANCE;

    private static final String READ_FRONT_COMMAND = "## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료";

    public FrontCommand readFrontCommand() {
        System.out.println(READ_FRONT_COMMAND);
        String command = Console.readLine();
        return FrontCommand.of(command);
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return 0;
    }
}
