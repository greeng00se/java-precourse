package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbersFactory;
import baseball.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameService());
        baseballGameController.run();
    }

    private static BaseballGameService baseballGameService() {
        return new BaseballGameService(baseballGame(), baseballNumbersFactory());
    }

    private static BaseballGame baseballGame() {
        return new BaseballGame();
    }

    private static BaseballNumbersFactory baseballNumbersFactory() {
        return new BaseballNumbersFactory();
    }
}
