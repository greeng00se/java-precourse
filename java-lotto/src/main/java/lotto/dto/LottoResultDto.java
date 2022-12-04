package lotto.dto;

import java.util.EnumMap;
import lotto.domain.LottoPrize;

public class LottoResultDto {

    private final EnumMap<LottoPrize, Long> result;
    private final double profitRatio;

    public LottoResultDto(EnumMap<LottoPrize, Long> result, double profitRatio) {
        this.result = result;
        this.profitRatio = profitRatio;
    }

    public EnumMap<LottoPrize, Long> getResult() {
        return result;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
