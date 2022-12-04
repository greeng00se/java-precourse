package lotto.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoDto {

    private static final String DELIMITER = ",";

    private final String winningNumber;
    private final String bonusNumber;

    public WinningLottoDto(String winningNumber, String bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return Arrays.stream(winningNumber.split(DELIMITER, -1))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        return Integer.valueOf(bonusNumber);
    }
}
