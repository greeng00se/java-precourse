package subway.controller;

import java.util.Arrays;

public enum LogicCommand {
    DISTANCE("1"),
    TIME("2"),
    BACK("B");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;

    LogicCommand(String command) {
        this.command = command;
    }

    public static LogicCommand from(String command) {
        return Arrays.stream(values())
                .filter(logicCommand -> logicCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isBack() {
        return this == BACK;
    }
}
