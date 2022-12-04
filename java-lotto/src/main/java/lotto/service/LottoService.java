package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.dto.AmountDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketDto;
import lotto.dto.WinningLottoDto;

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

    public LottoResultDto check(WinningLottoDto winningLottoDto) {
        LottoMachine lottoMachine = generateLottoMachine(winningLottoDto);
        LottoResult lottoResult = customer.check(lottoMachine);
        return new LottoResultDto(lottoResult.getResult(), lottoResult.calculateProfitRatio());
    }

    private LottoMachine generateLottoMachine(WinningLottoDto winningLottoDto) {
        Lotto winningNumber = new Lotto(winningLottoDto.getWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(winningLottoDto.getBonusNumber());
        return new LottoMachine(winningNumber, bonusNumber);
    }
}
