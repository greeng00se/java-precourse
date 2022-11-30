package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballGameStatus;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersFactory;
import baseball.dto.BaseballNumbersDto;
import baseball.dto.GameResultDto;
import baseball.dto.GameStatusDto;

public class BaseballGameService {

    private final BaseballGame baseballGame;
    private final BaseballNumbersFactory baseballNumbersFactory;

    public BaseballGameService(BaseballGame baseballGame, BaseballNumbersFactory baseballNumbersFactory) {
        this.baseballGame = baseballGame;
        this.baseballNumbersFactory = baseballNumbersFactory;
    }

    public void setupBaseballGame() {
        BaseballNumbers baseballNumbers = baseballNumbersFactory.generateBaseballNumbers();
        baseballGame.setup(baseballNumbers);
    }

    public GameResultDto playBaseballGame(BaseballNumbersDto player) {
        BaseballNumbers playerNumbers = baseballNumbersFactory.generateBaseballNumbers(player.getBaseballNumbers());
        BaseballGameResult result = baseballGame.play(playerNumbers);
        return new GameResultDto(result.getBall(), result.getStrike());
    }

    public boolean isPlayable() {
        return baseballGame.isPlayable();
    }

    public void replayBaseballGame(GameStatusDto gameStatusDto) {
        BaseballGameStatus baseballGameStatus = BaseballGameStatus.from(gameStatusDto.getCommand());
        if (baseballGameStatus.isPlayable()) {
            setupBaseballGame();
        }
    }
}
