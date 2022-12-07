package vendingmachine.domain;

import java.util.EnumMap;

public class Change {

    private static final int PLUS_COUNT = 1;
    private static final int ZERO_AMOUNT = 0;
    private static final int VALID_AMOUNT_REMAIN = 10;
    private static final String INVALID_AMOUNT_FORMAT_MESSAGE = "거스름돈은 10원 단위로 입력해야합니다.";

    private final EnumMap<Coin, Integer> change = new EnumMap<>(Coin.class);

    public Change(Integer amount) {
        validate(amount);
        toChange(amount);
    }

    private void validate(Integer amount) {
        if (amount % VALID_AMOUNT_REMAIN != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT_MESSAGE);
        }
    }

    private void toChange(Integer amount) {
        while (amount > ZERO_AMOUNT) {
            int coin = Coin.pickRandomCoinLessThanOrEqualTo(amount);
            amount -= coin;
            change.merge(Coin.from(coin), PLUS_COUNT, Integer::sum);
        }
    }

    public Integer calculateSum() {
        return Coin.descendingOrder().stream()
                .map(coin -> coin.amountMultiplyBy(change.getOrDefault(coin, ZERO_AMOUNT)))
                .reduce(ZERO_AMOUNT, Integer::sum);
    }

    public EnumMap<Coin, Integer> getChange() {
        return new EnumMap<>(change);
    }
}
