package baseball.domain;

import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGame 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameTest {

    private BaseballGame baseballGame;
    private BaseballNumbers baseballNumbers;

    @BeforeEach
    void setup() {
        List<BaseballNumber> baseballNumberList = List.of(valueOf(1), valueOf(2), valueOf(3));
        baseballNumbers = new BaseballNumbers(baseballNumberList);
        baseballGame = new BaseballGame();
    }

    @Test
    void setup_메서드는_BaseballNumbers를_입력받아_게임을_진행가능한_상태로_만든다() {
        baseballGame.setup(baseballNumbers);

        assertThat(baseballGame.isPlayable()).isTrue();
    }

    @Test
    void play_메서드는_사용자의_BaseballNumbers를_입력받아_게임을_진행한다() {
        baseballGame.setup(baseballNumbers);

        BaseballGameResult result = baseballGame.play(baseballNumbers);

        assertThat(result).isEqualTo(_3_STRIKE);
    }

    @Test
    void isPlayable_메서드는_게임_진행이_불가능_상태라면_false를_반환한다() {
        assertThat(baseballGame.isPlayable()).isFalse();
    }

    @Test
    void isPlayable_메서드는_게임_진행이_가능한_상태라면_true를_반환한다() {
        baseballGame.setup(baseballNumbers);

        assertThat(baseballGame.isPlayable()).isTrue();
    }
}
