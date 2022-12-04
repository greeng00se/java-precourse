package lotto.domain;

import static lotto.domain.Lotto.LOTTO_AMOUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final Long ZERO = 0L;
    private static final double DEFAULT_RATIO = 100.0;
    private static final double RATIO_OF_ZERO = 0.0;
    private final Map<LottoPrize, Long> result = new EnumMap<>(LottoPrize.class);

    public LottoResult(Map<LottoPrize, Long> result) {
        this.result.putAll(result);
    }

    public double calculateProfitRatio() {
        long buyAmount = calculateBuyAmount();
        if (buyAmount == ZERO) {
            return RATIO_OF_ZERO;
        }
        return calculateTotalPrize() / (double) buyAmount * DEFAULT_RATIO;
    }

    private long calculateBuyAmount() {
        return LOTTO_AMOUNT * Arrays.stream(LottoPrize.values())
                .map(this::getCount)
                .reduce(ZERO, Long::sum);
    }

    private long calculateTotalPrize() {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> prize.calculatePrize(getCount(prize)))
                .reduce(ZERO, Long::sum);
    }

    private long getCount(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, ZERO);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }

    public EnumMap<LottoPrize, Long> getResult() {
        return new EnumMap<>(result);
    }
}
