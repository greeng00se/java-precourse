package lotto.domain;

import static lotto.domain.LottoNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoMachine 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoMachineTest {

    private LottoMachine sut;

    @BeforeEach
    void setup() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = valueOf(7);
        sut = new LottoMachine(winningNumber, bonusNumber);
    }

    @Test
    void check_메서드는_Ticket을_받아_당첨결과를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto));

        LottoResult result = sut.check(lottoTicket);

        assertThat(result).isInstanceOf(LottoResult.class);
    }
}
