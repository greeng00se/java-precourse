package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoPrize Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoPrizeTest {

    @Test
    void calculatePrize_메서드는_당첨횟수를_입력받아_총_당첨금을_반환한다() {
        LottoPrize prize = _3RD_PRIZE;

        long result = prize.calculatePrize(5L);

        assertThat(result).isEqualTo(7_500_000L);
    }

    @ParameterizedTest
    @MethodSource
    void from_메서드는_당첨번호_갯수와_보너스_당첨여부를_입력받아_LottoPrize를_반환한다(
            int match,
            boolean bonusMatched,
            LottoPrize result) {
        LottoPrize lottoPrize = LottoPrize.from(match, bonusMatched);

        assertThat(lottoPrize).isEqualTo(result);
    }

    static Stream<Arguments> from_메서드는_당첨번호_갯수와_보너스_당첨여부를_입력받아_LottoPrize를_반환한다() {
        return Stream.of(
                Arguments.of(0, false, _NOTHING),
                Arguments.of(1, false, _NOTHING),
                Arguments.of(2, false, _NOTHING),
                Arguments.of(3, false, _5TH_PRIZE),
                Arguments.of(4, false, _4TH_PRIZE),
                Arguments.of(5, false, _3RD_PRIZE),
                Arguments.of(5, true, _2ND_PRIZE),
                Arguments.of(6, false, _1ST_PRIZE),
                Arguments.of(6, true, _1ST_PRIZE)
        );
    }

    @ParameterizedTest
    @CsvSource({"_2ND_PRIZE, true", "_1ST_PRIZE, false"})
    void isSecondPrize_메서드는_2등인지_확인하여_boolean을_반환한다(LottoPrize prize, boolean result) {
        assertThat(prize.isSecondPrize()).isEqualTo(result);
    }

    @Test
    void getPrize_메서드는_당첨금을_반환한다() {
        long prize = _1ST_PRIZE.getPrize();

        assertThat(prize).isEqualTo(2_000_000_000L);
    }

    @Test
    void getMatch_메서드는_당첨_개수를_반환한다() {
        int match = _1ST_PRIZE.getMatch();

        assertThat(match).isEqualTo(6);
    }
}
