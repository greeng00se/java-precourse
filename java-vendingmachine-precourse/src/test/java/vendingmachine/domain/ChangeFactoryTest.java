package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("ChangeFactory 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ChangeFactoryTest {

    private final ChangeFactory sut = new ChangeFactory();

    @Test
    void generate_메서드는_올바르지_않은_거스름돈_형식을_입력하면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> sut.generate(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("거스름돈은 10원 단위로 입력해야합니다.");
    }

    @Test
    void generate_메서드는_10원단위의_값을_입력하면_무작위로_거스름돈을_생성하여_반환한다() {
        Map<Coin, Integer> change = sut.generate(1000);

        Integer sumValue = change.keySet().stream()
                .map(coin -> coin.amountMultiplyBy(change.get(coin)))
                .reduce(0, Integer::sum);

        assertThat(sumValue).isEqualTo(1000);
    }
}
