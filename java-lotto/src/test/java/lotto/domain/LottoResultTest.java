package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoResult")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoResultTest {

    private static LottoResult generateLottoResult(long c1, long c2, long c3, long c4, long c5, long c6) {
        return new LottoResult(Map.of(
                _1ST_PRIZE, c1,
                _2ND_PRIZE, c2,
                _3RD_PRIZE, c3,
                _4TH_PRIZE, c4,
                _5TH_PRIZE, c5,
                _NOTHING, c6
        ));
    }

    @ParameterizedTest
    @MethodSource
    void calculateProfitRatio_메서드는_이익률을_반환한다(LottoResult lottoResult, double ratio) {
        double result = lottoResult.calculateProfitRatio();

        assertThat(result).isEqualTo(ratio);
    }

    static Stream<Arguments> calculateProfitRatio_메서드는_이익률을_반환한다() {
        return Stream.of(
                Arguments.of(generateLottoResult(0, 0, 0, 0, 1, 7), 62.5),
                Arguments.of(generateLottoResult(0, 1, 1, 0, 1, 997), 3150.5),
                Arguments.of(generateLottoResult(0, 0, 0, 1, 2, 29), 187.5),
                Arguments.of(generateLottoResult(0, 0, 0, 0, 1, 1), 250.0),
                Arguments.of(generateLottoResult(0, 1, 0, 0, 1, 7), 333388.8888888889),
                Arguments.of(generateLottoResult(1, 0, 0, 0, 0, 999), 200000.0),
                Arguments.of(generateLottoResult(0, 0, 0, 0, 0, 7), 0.0)
        );
    }

    @Test
    void getResult_메서드는_당첨_결과를_반환한다() {
        LottoResult lottoResult = generateLottoResult(1, 0, 0, 0, 0, 1);

        EnumMap<LottoPrize, Long> result = lottoResult.getResult();

        assertThat(result).containsValues(1L, 0L, 0L, 0L, 0L, 1L);
    }
}
