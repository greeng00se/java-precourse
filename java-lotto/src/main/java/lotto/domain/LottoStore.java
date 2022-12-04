package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_AMOUNT;
import static lotto.domain.Lotto.VALID_LOTTO_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;

import java.util.stream.Stream;

public class LottoStore {

    private static final int VALID_CHANGE_VALUE = 0;
    private static final String INVALID_LOTTO_AMOUNT_MESSAGE = "로또 금액은 {0}원 단위어야 합니다.";

    public LottoTicket sell(int amount) {
        validateAmount(amount);
        return Stream.generate(this::quickPick)
                .limit(amount / LOTTO_AMOUNT)
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_AMOUNT || amount % LOTTO_AMOUNT != VALID_CHANGE_VALUE) {
            throw new IllegalArgumentException(format(INVALID_LOTTO_AMOUNT_MESSAGE, LOTTO_AMOUNT));
        }
    }

    private Lotto quickPick() {
        return pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND, VALID_LOTTO_SIZE).stream()
                .sorted()
                .collect(collectingAndThen(toList(), Lotto::new));
    }
}
