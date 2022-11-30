package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("BaseballGameStatus enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameStatusTest {

    @Test
    void from_메서드는_1또는_2의_값이_아닌_다른_값을_입력받으면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> BaseballGameStatus.from("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 상태값이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource({"1, PLAY", "2, STOP"})
    void from_메서드는_1또는_2의_값을_입력받아_BaseballGameStatus_인스턴스를_반환한다(String command, BaseballGameStatus result) {
        BaseballGameStatus baseballGameStatus = BaseballGameStatus.from(command);

        assertThat(baseballGameStatus).isEqualTo(result);
    }

    @Test
    void playGame_메서드는_PLAY_인스턴스를_반환한다() {
        assertThat(BaseballGameStatus.playGame()).isEqualTo(BaseballGameStatus.PLAY);
    }

    @Test
    void stopGame_메서드는_STOP_인스턴스를_반환한다() {
        assertThat(BaseballGameStatus.stopGame()).isEqualTo(BaseballGameStatus.STOP);
    }

    @ParameterizedTest
    @CsvSource({"PLAY, true", "STOP, false"})
    void isPlayable_메서드는_게임_진행_가능_여부를_반환한다(BaseballGameStatus status, boolean result) {
        assertThat(status.isPlayable()).isEqualTo(result);
    }
}
