package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        RacingGameController racingGameController = new RacingGameController(racingGameService());
        racingGameController.run();
    }

    private static RacingGameService racingGameService() {
        return new RacingGameService(numberGenerator());
    }

    private static RandomNumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
