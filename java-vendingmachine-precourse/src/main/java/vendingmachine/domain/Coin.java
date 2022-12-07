package vendingmachine.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    COIN_0(0);

    private static final String INVALID_COIN_AMOUNT = "올바르지 않은 동전 가격입니다.";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static int pickRandomCoinLessThanOrEqualTo(int value) {
        if (COIN_0.amount > value) {
            throw new IllegalArgumentException(INVALID_COIN_AMOUNT);
        }
        return Arrays.stream(values())
                .map(coin -> coin.amount)
                .filter(amount -> amount <= value)
                .collect(collectingAndThen(toList(), Randoms::pickNumberInList));
    }

    public static List<Coin> descendingOrder() {
        return Arrays.stream(values())
                .filter(coin -> coin != COIN_0)
                .sorted(Comparator.comparingInt(Coin::getAmount).reversed())
                .collect(toList());
    }

    public static Coin from(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COIN_AMOUNT));
    }

    public Integer amountMultiplyBy(int times) {
        return this.amount * times;
    }

    public int getAmount() {
        return amount;
    }
}
