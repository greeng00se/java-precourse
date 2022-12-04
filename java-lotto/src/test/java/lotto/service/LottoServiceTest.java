package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Customer;
import lotto.domain.LottoStore;
import lotto.dto.AmountDto;
import lotto.dto.LottoTicketDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoServiceTest {

    private LottoService sut;

    @BeforeEach
    void setup() {
        LottoStore lottoStore = new LottoStore();
        Customer customer = new Customer();
        sut = new LottoService(lottoStore, customer);
    }

    @Test
    void buyLotto_메서드는_구매금액을_입력받아_구입한_로또를_반환한다() {
        AmountDto amountDto = new AmountDto("5000");

        LottoTicketDto lottoTicketDto = sut.buyLotto(amountDto);

        assertThat(lottoTicketDto.getLottoTicket()).hasSize(5);
    }

}
