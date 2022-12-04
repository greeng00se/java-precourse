package baseball.dto;

public class GameResultDto {

    private final int ball;
    private final int strike;

    public GameResultDto(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
