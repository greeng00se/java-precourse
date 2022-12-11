package subway.view;

import java.util.List;

public class InputValidator {

    private static final List<String> VALID_COMMAND = List.of("1", "Q");
    private static final List<String> VALID_LOGIC_COMMAND = List.of("1", "2", "B");
    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다";
    private static final String INVALID_PATH_MESSAGE = "출발역과 도착역이 동일합니다.";

    public void validateCommand(String command) {
        if (!VALID_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }

    public void validateLogicCommand(String command) {
        if (!VALID_LOGIC_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }

    public void validatePath(String start, String end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException(INVALID_PATH_MESSAGE);
        }
    }
}
