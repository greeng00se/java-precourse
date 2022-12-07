package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Change 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ChangeTest {

    @Test
    void calculateSum_메서드는_현재_남아있는_동전의_총합을_반환한다() {
        Change change = new Change(Map.of(COIN_500, 3));

        assertThat(change.calculateSum()).isEqualTo(1500);
    }

    @Test
    void getChangeLessThanOrEqualTo_메서드는_금액을_입력받아_최대한_근접한_값으로_거스름돈을_반환한다() {
        Change change = new Change(Map.of(COIN_500, 5, COIN_100, 10, COIN_50, 3, COIN_10, 17));

        Map<Coin, Integer> result = change.getChangeLessThanOrEqualTo(2670);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(
                Map.of(COIN_500, 5, COIN_100, 1, COIN_50, 1, COIN_10, 2)
        );
    }

    @Test
    void getChange_메서드는_현재_잔돈을_반환한다() {
        Change change = new Change(Map.of(COIN_500, 3, COIN_10, 17));

        Map<Coin, Integer> result = change.getChange();

        assertThat(result).containsExactlyInAnyOrderEntriesOf(Map.of(COIN_500, 3, COIN_10, 17));
    }
}
