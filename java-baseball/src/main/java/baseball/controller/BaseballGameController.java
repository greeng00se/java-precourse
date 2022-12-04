package baseball.controller;

import baseball.dto.BaseballNumbersDto;
import baseball.dto.GameResultDto;
import baseball.dto.GameStatusDto;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        outputView.printGameStart();
        baseballGameService.setupBaseballGame();
        playGame();
        outputView.printGameEnd();
    }

    private void playGame() {
        while (baseballGameService.isPlayable()) {
            BaseballNumbersDto baseballNumbers = inputView.readBaseballNumbers();
            GameResultDto baseballGameResult = baseballGameService.playBaseballGame(baseballNumbers);
            outputView.printGameResult(baseballGameResult);
            checkGameEnd();
        }
    }

    private void checkGameEnd() {
        if (!baseballGameService.isPlayable()) {
            GameStatusDto baseballGameStatus = inputView.readStatusCommand();
            baseballGameService.replayBaseballGame(baseballGameStatus);
        }
    }
}
