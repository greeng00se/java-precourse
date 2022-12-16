package pairmatching.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 반올림: RoundingMode.HALF_UP 내림: RoundingMode.DOWN setScale을 통해 소수점 자리수 제한가능
 */
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(Long amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public static Money wons(long amount) {
        return new Money(amount);
    }

    public Money plus(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money multiply(double multiplicand) {
        BigDecimal result = this.amount.multiply(BigDecimal.valueOf(multiplicand));
        return new Money(result.longValue());
    }

    public Money subtract(Money other) {
        return new Money(this.amount.subtract(other.amount));
    }

    public Money divideWithDown(long divisor) {
        return new Money(this.amount.divide(BigDecimal.valueOf(divisor), RoundingMode.DOWN));
    }

    public Money divideWithHalfUp(long divisor) {
        return new Money(this.amount.divide(BigDecimal.valueOf(divisor), RoundingMode.HALF_UP));
    }

    public Money calculateRemainder(Money other) {
        return new Money(this.amount.remainder(other.amount));
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public long getAmount() {
        return amount.longValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
