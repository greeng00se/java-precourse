package pairmatching.controller.command;

import java.util.Arrays;

public enum FrontControllerCommand {
    MATCHING("1"),
    SEARCH("2"),
    RESET("3"),
    QUIT("Q");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;

    FrontControllerCommand(String command) {
        this.command = command;
    }

    public static FrontControllerCommand from(String command) {
        return Arrays.stream(values())
                .filter(controllerCommand -> controllerCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isNotQuit() {
        return this != QUIT;
    }
}
