package lotto.domain;

public class LottoMachine {

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public LottoMachine(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult check(LottoTicket lottoTicket) {
        return lottoTicket.check(winningNumber, bonusNumber);
    }
}
