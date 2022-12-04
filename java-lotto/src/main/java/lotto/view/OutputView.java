package lotto.view;

import static java.text.MessageFormat.format;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.domain.LottoPrize;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketDto;

public class OutputView {

    private static final String LOTTO_TICKET_MESSAGE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final String MESSAGE_DELIMITER = "\n";
    private static final String RESULT_MESSAGE_FORMAT = "{0}개 일치{1} ({2}원) - {3}개";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY_MESSAGE = "";
    private static final long EMPTY_VALUE = 0L;
    private static final String PROFIT_RATIO_MESSAGE_FORMAT = "\n총 수익률은 {0}%입니다.";
    private static final String PROFIT_RATIO_ONE_DECIMAL_PLACE_FORMAT = "%,.1f";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printLottoTicket(LottoTicketDto lottoTicketDto) {
        System.out.println(format(LOTTO_TICKET_MESSAGE_FORMAT, lottoTicketDto.getLottoTicket().size()));
        System.out.println(generateLottoTicket(lottoTicketDto));
    }

    private String generateLottoTicket(LottoTicketDto lottoTicketDto) {
        return lottoTicketDto.getLottoTicket().stream()
                .map(Object::toString)
                .collect(Collectors.joining(MESSAGE_DELIMITER));
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println(generateResultMessages(lottoResultDto.getResult()));
        System.out.println(generateProfitRatioMessage(lottoResultDto.getProfitRatio()));
    }

    private String generateResultMessages(EnumMap<LottoPrize, Long> result) {
        return LottoPrize.lowestPrizeOrder().stream()
                .map(prize -> generateResultMessage(result, prize))
                .collect(Collectors.joining(MESSAGE_DELIMITER));
    }

    private static String generateResultMessage(EnumMap<LottoPrize, Long> result, LottoPrize prize) {
        return MessageFormat.format(
                RESULT_MESSAGE_FORMAT,
                prize.getMatch(),
                checkSecondPrize(prize),
                prize.getPrize(),
                result.getOrDefault(prize, EMPTY_VALUE)
        );
    }

    private static String checkSecondPrize(LottoPrize prize) {
        if (prize.isSecondPrize()) {
            return BONUS_MESSAGE;
        }
        return EMPTY_MESSAGE;
    }

    private String generateProfitRatioMessage(double profitRatio) {
        return MessageFormat.format(
                PROFIT_RATIO_MESSAGE_FORMAT,
                String.format(PROFIT_RATIO_ONE_DECIMAL_PLACE_FORMAT, profitRatio)
        );
    }

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
