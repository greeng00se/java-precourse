package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

public class ChangeFactory {

    private static final int PLUS_COUNT = 1;
    private static final int ZERO = 0;
    private static final int VALID_AMOUNT_REMAIN = 10;
    private static final String INVALID_AMOUNT_FORMAT_MESSAGE = "거스름돈은 10원 단위로 입력해야합니다.";

    public Map<Coin, Integer> generate(Integer amount) {
        validate(amount);
        return generateChange(amount);
    }

    private void validate(Integer amount) {
        if (amount % VALID_AMOUNT_REMAIN != ZERO) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT_MESSAGE);
        }
    }

    private Map<Coin, Integer> generateChange(Integer amount) {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        while (amount > ZERO) {
            int coin = Coin.pickRandomCoinLessThanOrEqualTo(amount);
            amount -= coin;
            change.merge(Coin.from(coin), PLUS_COUNT, Integer::sum);
        }
        return change;
    }
}
