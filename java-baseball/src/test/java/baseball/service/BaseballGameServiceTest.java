package baseball.service;

import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersFactory;
import baseball.dto.BaseballNumbersDto;
import baseball.dto.GameResultDto;
import baseball.dto.GameStatusDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGameService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameServiceTest {

    private BaseballGame baseballGame;
    private BaseballGameService sut;

    @BeforeEach
    void setup() {
        BaseballNumbersFactory baseballNumbersFactory = new BaseballNumbersFactory();
        baseballGame = new BaseballGame();
        sut = new BaseballGameService(baseballGame, baseballNumbersFactory);
    }

    @Test
    void setupBaseballGame_메서드는_게임을_진행_가능한_상태로_만든다() {
        sut.setupBaseballGame();

        assertThat(baseballGame.isPlayable()).isTrue();
    }

    @Test
    void playBaseballGame_메서드는_사용자의_입력을_받아_게임을_진행한고_게임의_결과를_반환한다() {
        List<BaseballNumber> computerNumbers = List.of(valueOf(1), valueOf(2), valueOf(3));
        baseballGame.setup(new BaseballNumbers(computerNumbers));
        BaseballNumbersDto playerInput = new BaseballNumbersDto("123");

        GameResultDto gameResultDto = sut.playBaseballGame(playerInput);

        assertThat(gameResultDto.getStrike()).isEqualTo(3);
    }

    @Test
    void isPlayable_메서드는_현재_게임이_진행_가능한지_확인한다() {
        assertThat(sut.isPlayable()).isFalse();
    }

    @Test
    void retryBaseballGame_메서드는_사용자의_값을_받아_게임의_상태를_변경한다() {
        GameStatusDto givenInput = new GameStatusDto("1");

        sut.replayBaseballGame(givenInput);

        assertThat(sut.isPlayable()).isTrue();
    }
}
