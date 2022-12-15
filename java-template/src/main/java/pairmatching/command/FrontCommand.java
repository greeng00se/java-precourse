package pairmatching.command;

import java.util.Arrays;

public enum FrontCommand implements Command {
    MATCHING("1"),
    SEARCH("2"),
    RESET("3"),
    QUIT("Q");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;

    FrontCommand(String command) {
        this.command = command;
    }

    public static FrontCommand of(String name) {
        return Arrays.stream(values())
                .filter(command -> command.command.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isContinuous() {
        return this != QUIT;
    }
}
