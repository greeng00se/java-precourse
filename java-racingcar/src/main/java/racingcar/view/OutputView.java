package racingcar.view;

import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.joining;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.PlayResultDto;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "\n실행 결과";
    private static final String PLAY_RESULT_CAR_MESSAGE_FORMAT = "{0} : {1}";
    private static final String PLAY_RESULT_DELIMITER = "\n";
    private static final String PLAY_RESULT_MOVE_MESSAGE = "-";
    private static final String GAME_RESULT_MESSAGE_FORMAT = "최종 우승자 : {0}";
    private static final String GAME_RESULT_DELIMITER = ", ";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printPlayResult(PlayResultDto playResult) {
        System.out.println(PLAY_RESULT_MESSAGE);
        System.out.println(generatePlayResults(playResult));
    }

    private String generatePlayResults(PlayResultDto gameResult) {
        return gameResult.getCars().stream()
                .map(this::generatePlayResult)
                .collect(joining(PLAY_RESULT_DELIMITER));
    }

    private String generatePlayResult(CarDto car) {
        return format(PLAY_RESULT_CAR_MESSAGE_FORMAT, car.getName(),
                generateCarMove(car.getMove()));
    }

    private String generateCarMove(int move) {
        return PLAY_RESULT_MOVE_MESSAGE.repeat(move);
    }

    public void printGameResult(GameResultDto gameResult) {
        System.out.println(format(GAME_RESULT_MESSAGE_FORMAT, generateGameResult(gameResult.getCars())));
    }

    private String generateGameResult(List<String> cars) {
        return cars.stream()
                .collect(joining(GAME_RESULT_DELIMITER));
    }

    void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
