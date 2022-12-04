package lotto.domain;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Customer 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerTest {

    @Test
    void buyLottoTicket_메서드는_상점과_금액을_입력받아_로또를_구매한다() {
        Customer customer = new Customer();
        LottoStore lottoStore = mock(LottoStore.class);

        customer.buyLottoTicket(lottoStore, 1000);

        verify(lottoStore, only()).sell(1000);
    }

    @Test
    void check_메서드는_상점과_금액을_입력받아_로또를_구매한다() {
        Customer customer = new Customer();
        customer.buyLottoTicket(new LottoStore(), 1000);
        LottoMachine lottoMachine = mock(LottoMachine.class);

        customer.check(lottoMachine);

        verify(lottoMachine, only()).check(any(LottoTicket.class));
    }
}
