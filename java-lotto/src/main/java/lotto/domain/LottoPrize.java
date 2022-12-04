package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {

    _1ST_PRIZE(6, 2_000_000_000L),
    _2ND_PRIZE(5, 30_000_000L),
    _3RD_PRIZE(5, 1_500_000L),
    _4TH_PRIZE(4, 50_000L),
    _5TH_PRIZE(3, 5_000L),
    _NOTHING(0, 0L);

    private final int match;
    private final long prize;

    LottoPrize(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize from(int match, boolean bonusMatched) {
        LottoPrize lottoPrize = getLottoPrize(match);
        return checkSecondPrize(lottoPrize, bonusMatched);
    }

    private static LottoPrize getLottoPrize(int match) {
        return lowestPrizeOrder().stream()
                .filter(prize -> prize.match == match)
                .findFirst()
                .orElse(_NOTHING);
    }

    private static List<LottoPrize> lowestPrizeOrder() {
        return Arrays.stream(values())
                .filter(prize -> prize != _NOTHING)
                .sorted(Comparator.comparingLong(o -> o.prize))
                .collect(Collectors.toList());
    }

    private static LottoPrize checkSecondPrize(LottoPrize lottoPrize, boolean bonusMatched) {
        if (lottoPrize == _3RD_PRIZE && bonusMatched) {
            return _2ND_PRIZE;
        }
        return lottoPrize;
    }

    public long calculatePrize(long count) {
        return this.prize * count;
    }

    public boolean isSecondPrize() {
        return this == _2ND_PRIZE;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }
}
