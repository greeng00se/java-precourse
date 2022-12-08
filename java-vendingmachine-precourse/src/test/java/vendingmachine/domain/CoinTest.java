package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;
import static vendingmachine.domain.Coin.descendingOrder;
import static vendingmachine.domain.Coin.pickRandomCoinLessThanOrEqualTo;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Coin Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CoinTest {

    @Test
    void pickRandomCoinLessThanOrEqualTo_메서드는_0보다_작은_값을_입력하면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> pickRandomCoinLessThanOrEqualTo(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 동전 가격입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000, 500})
    void pickRandomCoinLessThanOrEqualTo_메서드는_입력값보다_작은_동전값을_무작위로_반환한다(int amount) {
        int coin = pickRandomCoinLessThanOrEqualTo(amount);

        assertThat(coin).isLessThanOrEqualTo(amount);
    }

    @Test
    void descendingOrder_메서드는_Coin을_내림차순으로_반환한다() {
        List<Coin> coins = descendingOrder();

        assertThat(coins).containsExactly(COIN_500, COIN_100, COIN_50, COIN_10);
    }

    @Test
    void from_메서드는_입력한_값에_대한_Coin이_존재하지_않는경우_IllegalArgumentException를_던진다() {
        assertThatThrownBy(() -> Coin.from(501))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 동전 가격입니다.");
    }

    @Test
    void from_메서드는_입력한_값에_대한_동일한_금액의_Coin을_반환한다() {
        Coin coin = Coin.from(500);

        assertThat(coin).isEqualTo(COIN_500);
    }

    @Test
    void amountMultiplyBy_메서드는_입력값에_Coin의_amount을_곱한값을_반환한다() {
        Coin coin = Coin.from(500);

        assertThat(coin.amountMultiplyBy(5)).isEqualTo(2500);
    }

    @Test
    void getAmount_메서드는_Coin의_amount값을_반환한다() {
        assertThat(COIN_500.getAmount()).isEqualTo(500);
    }
}
