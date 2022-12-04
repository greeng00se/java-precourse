package lotto.dto;

import java.util.List;

public class LottoTicketDto {

    private final List<List<Integer>> lottoTicket;

    public LottoTicketDto(List<List<Integer>> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<List<Integer>> getLottoTicket() {
        return lottoTicket;
    }
}
