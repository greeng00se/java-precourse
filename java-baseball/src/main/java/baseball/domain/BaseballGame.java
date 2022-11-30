package baseball.domain;

public class BaseballGame {

    private BaseballNumbers computer;
    private BaseballGameStatus status;

    public BaseballGame() {
        this.status = BaseballGameStatus.stopGame();
    }

    public void setup(BaseballNumbers baseballNumbers) {
        computer = baseballNumbers;
        status = BaseballGameStatus.playGame();
    }

    public BaseballGameResult play(BaseballNumbers player) {
        BaseballGameResult result = computer.play(player);
        checkStrikeOut(result);
        return result;
    }

    private void checkStrikeOut(BaseballGameResult result) {
        if (result.isStrikeOut()) {
            status = BaseballGameStatus.stopGame();
        }
    }

    public boolean isPlayable() {
        return status.isPlayable();
    }
}
