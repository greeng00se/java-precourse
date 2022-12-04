package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoTicket 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTicketTest {

    @Test
    void check_메서드는_구매한_로또와_당첨번호를_비교하여_결과를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto, lotto));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoNumber bonusNumber = LottoNumber.valueOf(6);

        LottoResult result = lottoTicket.check(winningNumber, bonusNumber);

        assertThat(result).isInstanceOf(LottoResult.class);
    }

    @Test
    void getTicket_메서드는_구매한_로또번호를_전부_반환한다() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto1, lotto2));

        List<List<Integer>> ticket = lottoTicket.getTicket();

        assertThat(ticket).containsExactly(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7));
    }
}
