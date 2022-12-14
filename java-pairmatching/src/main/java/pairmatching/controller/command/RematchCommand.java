package pairmatching.controller.command;

import java.util.Arrays;

public enum RematchCommand {
    YES("예"),
    NO("아니오");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;

    RematchCommand(String command) {
        this.command = command;
    }

    public static RematchCommand from(String command) {
        return Arrays.stream(values())
                .filter(rematchCommand -> rematchCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isRematch() {
        return this == YES;
    }
}
