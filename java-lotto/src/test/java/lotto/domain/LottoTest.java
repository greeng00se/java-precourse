package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest(name = "구매번호가 [1, 2, 3, 4, 5, 6]이고 당첨번호가{0} 보너스번호가 {1}인경우 반환값은 {2}")
    @MethodSource
    void check_메서드는_당첨번호와_현재_로또를_비교하여_당첨결과를_반환한다(
            Lotto winningNumber,
            LottoNumber bonusNumber,
            LottoPrize result
    ) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoPrize prize = lotto.check(winningNumber, bonusNumber);

        assertThat(prize).isEqualTo(result);
    }

    static List<Arguments> check_메서드는_당첨번호와_현재_로또를_비교하여_당첨결과를_반환한다() {
        return Arrays.asList(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), _1ST_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), LottoNumber.valueOf(6), _2ND_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), LottoNumber.valueOf(7), _3RD_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 44, 45)), LottoNumber.valueOf(7), _4TH_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 43, 44, 45)), LottoNumber.valueOf(7), _5TH_PRIZE),
                Arguments.of(new Lotto(List.of(40, 41, 42, 43, 44, 45)), LottoNumber.valueOf(7), _NOTHING)
        );
    }

    @Test
    void getNumbers_메서드는_로또번호를_Integer형식으로_변경하여_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> result = lotto.getNumbers();

        Assertions.assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
