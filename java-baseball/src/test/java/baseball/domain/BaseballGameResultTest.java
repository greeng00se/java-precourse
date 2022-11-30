package baseball.domain;


import static baseball.domain.BaseballGameResult._1_BALL;
import static baseball.domain.BaseballGameResult._1_BALL_1_STRIKE;
import static baseball.domain.BaseballGameResult._1_STRIKE;
import static baseball.domain.BaseballGameResult._2_BALL;
import static baseball.domain.BaseballGameResult._2_BALL_1_STRIKE;
import static baseball.domain.BaseballGameResult._2_STRIKE;
import static baseball.domain.BaseballGameResult._3_BALL;
import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballGameResult._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballGameResult enum")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BaseballGameResultTest {

    @Test
    void from_메서드는_올바른_결과값을_입력받지_않으면_IllegalArgumentException을_던진다() {
        Assertions.assertThatThrownBy(() -> BaseballGameResult.from(0, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 결과 값입니다.");
    }

    @ParameterizedTest
    @MethodSource
    void from_메서드는_결과값을_입력받아_BaseballGameResult_인스턴스를_반환한다(int ball, int strike, BaseballGameResult result) {
        BaseballGameResult baseballGameResult = BaseballGameResult.from(ball, strike);

        assertThat(baseballGameResult).isEqualTo(result);
    }

    static Stream<Arguments> from_메서드는_결과값을_입력받아_BaseballGameResult_인스턴스를_반환한다() {
        return Stream.of(
                Arguments.of(0, 0, _NOTHING),
                Arguments.of(0, 3, _3_STRIKE),
                Arguments.of(0, 2, _2_STRIKE),
                Arguments.of(0, 1, _1_STRIKE),
                Arguments.of(3, 0, _3_BALL),
                Arguments.of(2, 0, _2_BALL),
                Arguments.of(1, 0, _1_BALL),
                Arguments.of(2, 1, _2_BALL_1_STRIKE),
                Arguments.of(1, 1, _1_BALL_1_STRIKE)
        );
    }

    @Test
    void getBall_메서드는_ball값을_반환한다() {
        assertThat(_2_BALL_1_STRIKE.getBall()).isEqualTo(2);
    }

    @Test
    void getStrike_메서드는_strike값을_반환한다() {
        assertThat(_3_STRIKE.getStrike()).isEqualTo(3);
    }
}
