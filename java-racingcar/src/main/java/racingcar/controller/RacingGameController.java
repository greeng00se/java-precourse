package racingcar.controller;

import java.util.function.Supplier;
import racingcar.dto.CarNamesDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.PlayCountDto;
import racingcar.dto.PlayResultDto;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        setupRacingGame();
        race();
        ceremony();
    }

    private void setupRacingGame() {
        CarNamesDto carNamesDto = repeat(inputView::readRacingCarNames);
        PlayCountDto playCountDto = repeat(inputView::readPlayCount);
        racingGameService.setupRacingGame(carNamesDto, playCountDto);
    }

    private void race() {
        outputView.printPlayResultMessage();
        while (racingGameService.isPlayable()) {
            PlayResultDto playResultDto = racingGameService.race();
            outputView.printPlayResult(playResultDto);
        }
    }


    private void ceremony() {
        GameResultDto winners = racingGameService.getWinners();
        outputView.printGameResult(winners);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return repeat(inputReader);
        }
    }
}
