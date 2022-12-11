package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.dto.CommandDto;
import subway.dto.PathDto;

public class InputView {

    private static final String MAIN_MESSAGE = "## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n";
    private static final String LOGIC_MESSAGE = "## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간 \n"
            + "B. 돌아가기";
    private static final String READ_COMMAND_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private static final String READ_START_STATION = "\n## 출발역을 입력하세요.";
    private static final String READ_END_STATION = "\n## 도착역을 입력하세요.";

    private final InputValidator inputValidator = new InputValidator();

    public CommandDto readCommand() {
        System.out.println(MAIN_MESSAGE);
        System.out.println(READ_COMMAND_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateCommand(command);
        return new CommandDto(command);
    }

    public CommandDto readLogicCommand() {
        System.out.println(LOGIC_MESSAGE);
        System.out.println(READ_COMMAND_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateLogicCommand(command);
        return new CommandDto(command);
    }

    public PathDto readPath() {
        System.out.println(READ_START_STATION);
        String start = Console.readLine();
        System.out.println(READ_END_STATION);
        String end = Console.readLine();
        inputValidator.validatePath(start, end);
        return new PathDto(start, end);
    }
}
