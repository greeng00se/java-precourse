package baseball.domain;

import java.util.Arrays;

public enum BaseballGameResult {
    _3_STRIKE(0, 3),
    _2_STRIKE(0, 2),
    _1_STRIKE(0, 1),
    _3_BALL(3, 0),
    _2_BALL(2, 0),
    _1_BALL(1, 0),
    _2_BALL_1_STRIKE(2, 1),
    _1_BALL_1_STRIKE(1, 1),
    _NOTHING(0, 0);

    private static final String INVALID_RESULT_MESSAGE = "올바르지 않은 결과 값입니다.";

    private final int ball;
    private final int strike;

    BaseballGameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BaseballGameResult from(int ball, int strike) {
        return Arrays.stream(values())
                .filter(result -> result.ball == ball)
                .filter(result -> result.strike == strike)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESULT_MESSAGE));
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
