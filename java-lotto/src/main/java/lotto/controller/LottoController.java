package lotto.controller;

import lotto.dto.AmountDto;
import lotto.dto.LottoTicketDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        buyLottoTicket();
    }

    private void buyLottoTicket() {
        AmountDto amountDto = inputView.readBuyAmount();
        LottoTicketDto lottoTicketDto = lottoService.buyLotto(amountDto);
        outputView.printLottoTicket(lottoTicketDto);
    }
}
