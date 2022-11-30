package baseball.domain;

import java.util.Arrays;

public enum BaseballGameStatus {
    PLAY("1"),
    STOP("2");

    private static final String INVALID_GAME_STATUS_MESSAGE = "올바른 상태값이 아닙니다.";

    private final String command;

    BaseballGameStatus(String command) {
        this.command = command;
    }

    public static BaseballGameStatus from(String command) {
        return Arrays.stream(values())
                .filter(status -> status.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_STATUS_MESSAGE));
    }
}
