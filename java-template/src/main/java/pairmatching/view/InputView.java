package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.command.FrontCommand;

public enum InputView {
    INSTANCE;

    private static final String READ_FRONT_COMMAND = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public FrontCommand readFrontCommand() {
        System.out.println(READ_FRONT_COMMAND);
        String command = Console.readLine();
        return FrontCommand.of(command);
    }
}
