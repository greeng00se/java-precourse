package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLottoDto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinningLottoDtoTest {

    @Test
    void getWinningNumbers는_쉼표로_분리한_Integer리스트를_반환한다() {
        WinningLottoDto winningLottoDto = new WinningLottoDto("1,2,3,4,5,6", "7");

        List<Integer> winningNumber = winningLottoDto.getWinningNumber();

        assertThat(winningNumber).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void getBonusNumber는_Integer로_변환하여_반환한다() {
        WinningLottoDto winningLottoDto = new WinningLottoDto("1,2,3,4,5,6", "7");

        Integer bonusNumber = winningLottoDto.getBonusNumber();

        assertThat(bonusNumber).isEqualTo(7);
    }
}
