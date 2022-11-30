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
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballNumbers")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BaseballNumbersTest {

    List<BaseballNumber> generateBaseballNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(BaseballNumber::valueOf)
                .collect(toList());
    }

    @ParameterizedTest
    @MethodSource
    void 생성자는_중복되거나_올바른_값이_아닌_야구공_리스트를_입력받으면_IllegalArgumentException을_던진다(List<Integer> numbers) {
        List<BaseballNumber> baseballNumbers = generateBaseballNumber(numbers);

        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 BaseballNumbers 입력값이 아닙니다.");
    }

    static Stream<Arguments> 생성자는_중복되거나_올바른_값이_아닌_야구공_리스트를_입력받으면_IllegalArgumentException을_던진다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(7, 7, 8)),
                Arguments.of(List.of(1, 2, 3, 3)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1))
        );
    }

    @Test
    void 생성자는_중복되지_않은_3개의_값을_입력받으면_Exception을_던지지_않는다() {
        List<BaseballNumber> givenBaseballNumbers = generateBaseballNumber(List.of(7, 4, 5));

        assertThatNoException().isThrownBy(() -> new BaseballNumbers(givenBaseballNumbers));
    }

    @ParameterizedTest
    @MethodSource
    void play_메서드는_다른_BaseballNumbers를_입력받아_BaseballGameResult를_반환한다(
            List<Integer> numbers,
            BaseballGameResult result
    ) {
        BaseballNumbers computer = new BaseballNumbers(generateBaseballNumber(List.of(1, 2, 3)));
        BaseballNumbers player = new BaseballNumbers(generateBaseballNumber(numbers));

        BaseballGameResult baseballGameResult = computer.play(player);

        assertThat(baseballGameResult).isEqualTo(result);
    }

    static Stream<Arguments> play_메서드는_다른_BaseballNumbers를_입력받아_BaseballGameResult를_반환한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), _3_STRIKE),
                Arguments.of(List.of(1, 2, 9), _2_STRIKE),
                Arguments.of(List.of(1, 8, 9), _1_STRIKE),
                Arguments.of(List.of(2, 3, 1), _3_BALL),
                Arguments.of(List.of(2, 3, 9), _2_BALL),
                Arguments.of(List.of(2, 8, 9), _1_BALL),
                Arguments.of(List.of(2, 1, 3), _2_BALL_1_STRIKE),
                Arguments.of(List.of(2, 8, 3), _1_BALL_1_STRIKE),
                Arguments.of(List.of(7, 8, 9), _NOTHING)
        );
    }
}
