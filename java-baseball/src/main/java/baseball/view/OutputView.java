package baseball.view;

import baseball.dto.GameResultDto;
import java.text.MessageFormat;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MESSAGE = "{0}볼";
    private static final String STRIKE_MESSAGE = "{0}스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String RESULT_MESSAGE_FORMAT = "{0} {1}";
    private static final int ZERO_RESULT = 0;
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameResult(GameResultDto gameResultDto) {
        System.out.println(generateGameResultMessage(gameResultDto.getBall(), gameResultDto.getStrike()));
    }

    private String generateGameResultMessage(int ball, int strike) {
        if (ball == ZERO_RESULT && strike == ZERO_RESULT) {
            return NOTHING_MESSAGE;
        }

        if (ball > ZERO_RESULT && strike == ZERO_RESULT) {
            return generateBallMessage(ball);
        }

        if (strike > ZERO_RESULT && ball == ZERO_RESULT) {
            return generateStrikeMessage(strike);
        }

        return MessageFormat.format(RESULT_MESSAGE_FORMAT, generateBallMessage(ball), generateStrikeMessage(strike));
    }

    private static String generateBallMessage(int ball) {
        return MessageFormat.format(BALL_MESSAGE, ball);
    }

    private static String generateStrikeMessage(int strike) {
        return MessageFormat.format(STRIKE_MESSAGE, strike);
    }

    public void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }
}
