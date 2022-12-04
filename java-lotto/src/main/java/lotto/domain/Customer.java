package lotto.domain;

import java.util.List;

public class Customer {

    private LottoTicket lottoTicket;

    public void buyLottoTicket(LottoStore lottoStore, int amount) {
        lottoTicket = lottoStore.sell(amount);
    }

    public LottoResult check(LottoMachine lottoMachine) {
        return lottoMachine.check(lottoTicket);
    }

    public List<List<Integer>> getLottoTicket() {
        return lottoTicket.getTicket();
    }
}
