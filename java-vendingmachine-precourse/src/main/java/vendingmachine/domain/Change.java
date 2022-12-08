package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

public class Change {

    private static final int ZERO_AMOUNT = 0;

    private final EnumMap<Coin, Integer> change = new EnumMap<>(Coin.class);

    public Change() {
    }

    public Change(Map<Coin, Integer> change) {
        this.change.putAll(change);
    }

    public void fillChange(Map<Coin, Integer> change) {
        for (Coin coin : change.keySet()) {
            this.change.merge(coin, change.get(coin), Integer::sum);
        }
    }

    public Integer calculateSum() {
        return Coin.descendingOrder().stream()
                .map(coin -> coin.amountMultiplyBy(change.getOrDefault(coin, ZERO_AMOUNT)))
                .reduce(ZERO_AMOUNT, Integer::sum);
    }

    public Map<Coin, Integer> getChangeLessThanOrEqualTo(Integer value) {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.descendingOrder()) {
            Integer maximumChangeCount = calculateMaximumChangeCount(value, coin);
            result.put(coin, maximumChangeCount);
            value -= coin.amountMultiplyBy(maximumChangeCount);
        }
        return result;
    }

    private Integer calculateMaximumChangeCount(Integer value, Coin coin) {
        int count = value / coin.getAmount();
        Integer coinCount = change.getOrDefault(coin, ZERO_AMOUNT);
        int maximumChangeCount = Integer.min(count, coinCount);
        change.put(coin, coinCount - maximumChangeCount);
        return maximumChangeCount;
    }

    public Map<Coin, Integer> getChange() {
        return new EnumMap<>(change);
    }
}
