package subway.controller;

import java.util.Arrays;

public enum ControllerCommand {
    SEARCH("1"),
    QUIT("Q");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;

    ControllerCommand(String command) {
        this.command = command;
    }

    public static ControllerCommand from(String command) {
        return Arrays.stream(values())
                .filter(controllerCommand -> controllerCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isNotQuit() {
        return this != QUIT;
    }
}
