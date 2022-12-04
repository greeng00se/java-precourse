package lotto.view;

import static java.text.MessageFormat.format;

import java.util.stream.Collectors;
import lotto.dto.LottoTicketDto;

public class OutputView {

    private static final String LOTTO_TICKET_MESSAGE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final String LOTTO_TICKET_DELIMITER = "\n";


    public void printLottoTicket(LottoTicketDto lottoTicketDto) {
        System.out.println(format(LOTTO_TICKET_MESSAGE_FORMAT, lottoTicketDto.getLottoTicket().size()));
        System.out.println(generateLottoTicket(lottoTicketDto));
    }

    private String generateLottoTicket(LottoTicketDto lottoTicketDto) {
        return lottoTicketDto.getLottoTicket().stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_TICKET_DELIMITER));
    }
}
