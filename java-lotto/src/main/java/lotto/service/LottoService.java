package lotto.service;

import lotto.domain.Customer;
import lotto.domain.LottoStore;
import lotto.dto.AmountDto;
import lotto.dto.LottoTicketDto;

public class LottoService {

    private final LottoStore lottoStore;
    private final Customer customer;

    public LottoService(LottoStore lottoStore, Customer customer) {
        this.lottoStore = lottoStore;
        this.customer = customer;
    }

    public LottoTicketDto buyLotto(AmountDto amountDto) {
        customer.buyLottoTicket(lottoStore, amountDto.getAmount());
        return new LottoTicketDto(customer.getLottoTicket());
    }
}
