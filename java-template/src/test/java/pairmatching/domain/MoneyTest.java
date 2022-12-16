package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Money 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {

    @Test
    void wons_메서드는_long타입의_값을_입력받아_Money_인스턴스를_반환한다() {
        Money money = Money.wons(1_000L);

        assertThat(money).isEqualTo(new Money(1_000L));
    }

    @Test
    void plus_메서드는_덧셈연산을_수행하고_결과를_반환한다() {
        Money money = Money.wons(1_000L);
        Money augend = Money.wons(1_500L);

        Money result = money.plus(augend);

        assertThat(result).isEqualTo(new Money(2_500L));
    }

    @Test
    void multiply_메서드는_곱셈연산을_수행하고_결과를_반환한다() {
        Money money = Money.wons(1_000L);

        Money result = money.multiply(0.1);

        assertThat(result).isEqualTo(new Money(100L));
    }

    @Test
    void subtract_메서드는_뺄샘연산_수행하고_결과를_반환한다() {
        Money money = Money.wons(1_000L);
        Money subtrahend = new Money(450L);

        Money result = money.subtract(subtrahend);

        assertThat(result).isEqualTo(new Money(550L));
    }

    @Test
    void divideWithDown_메서드는_나눗셈연산을_수행하고_결과를_내림하여_반환한다() {
        Money money = Money.wons(1_000L);

        Money result = money.divideWithDown(3L);

        assertThat(result).isEqualTo(new Money(333L));
    }

    @Test
    void divideWithHalfUp_메서드는_나눗셈연산을_수행하고_결과를_반올림하여_반환한다() {
        Money money = Money.wons(1_000L);

        Money result = money.divideWithHalfUp(6L);

        assertThat(result).isEqualTo(new Money(167L));
    }

    @Test
    void calculateRemainder_메서드는_나머지연산을_수행하고_결과를_반환한다() {
        Money money = Money.wons(1_000L);

        Money result = money.calculateRemainder(new Money(4L));

        assertThat(result).isEqualTo(Money.ZERO);
    }

    @ParameterizedTest
    @CsvSource({"1000, true", "999, true", "1001, false"})
    void isGreaterThanOrEqual_메서드는_비교연산을_수행하여_현재_값이_입력값보다_크거나_같으면_참을_반환한다(long amount, boolean result) {
        Money money = Money.wons(1_000L);

        assertThat(money.isGreaterThanOrEqual(Money.wons(amount))).isEqualTo(result);
    }

    @Test
    void getAmount_메서드는_long_타입의_값을_반환한다() {
        Money money = Money.wons(1_000L);

        assertThat(money.getAmount()).isEqualTo(1_000L);
    }
}
