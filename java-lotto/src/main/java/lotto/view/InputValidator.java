package lotto.view;

import static java.text.MessageFormat.format;

public class InputValidator {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바른 숫자 형식이 아닙니다.";
    private static final int VALID_LOTTO_PRICE = 1000;
    private static final String INVALID_AMOUNT_MESSAGE = "구입 금액은 {0}원 단위어야 합니다.";

    public void validateBuyAmount(String amount) {
        Integer value = toInteger(amount);
        validateAmountRange(value);
    }

    private Integer toInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateAmountRange(Integer amount) {
        if (amount < VALID_LOTTO_PRICE || amount % VALID_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(format(INVALID_AMOUNT_MESSAGE, VALID_LOTTO_PRICE));
        }
    }
}
