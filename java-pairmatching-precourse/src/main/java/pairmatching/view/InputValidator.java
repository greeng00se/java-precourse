package pairmatching.view;

import java.util.List;

public class InputValidator {

    private static final List<String> VALID_COMMAND = List.of("1", "2", "3", "Q");
    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다";

    public void validateCommand(String command) {
        if (!VALID_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }
}
