package lotto.view;

import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바른 숫자 형식이 아닙니다.";
    private static final int VALID_LOTTO_PRICE = 1000;
    private static final String INVALID_AMOUNT_MESSAGE = "구입 금액은 {0}원 단위어야 합니다.";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int WINNING_NUMBER_SPLIT_INDEX = -1;
    private static final String INVALID_LOTTO_FORMAT_MESSAGE = ",로 구분된 올바른 로또 번호 형식을 입력해주세요.";
    private static final int VALID_LOTTO_SIZE = 6;
    private static final int VALID_LOTTO_LOWER_BOUND = 1;
    private static final int VALID_LOTTO_UPPER_BOUND = 45;

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

    public void validateWinningNumbers(String winningNumbers) {
        List<Integer> lotto = toIntegerList(winningNumbers);
        validateLottoSize(lotto);
        for (Integer number : lotto) {
            validateLottoNumberRange(number);
        }
    }

    private List<Integer> toIntegerList(String winningNumber) {
        return Arrays.stream(winningNumber.split(WINNING_NUMBER_DELIMITER, WINNING_NUMBER_SPLIT_INDEX))
                .map(this::toInteger)
                .collect(toList());
    }

    private void validateLottoSize(List<Integer> lotto) {
        HashSet<Integer> nonDuplicateLotto = new HashSet<>(lotto);
        if (lotto.size() != VALID_LOTTO_SIZE || nonDuplicateLotto.size() != VALID_LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_FORMAT_MESSAGE);
        }
    }

    private void validateLottoNumberRange(Integer number) {
        if (number < VALID_LOTTO_LOWER_BOUND || VALID_LOTTO_UPPER_BOUND < number) {
            throw new IllegalArgumentException(INVALID_LOTTO_FORMAT_MESSAGE);
        }
    }

    public void validateBonusNumber(String bonus, String winning) {
        List<Integer> winningNumbers = toIntegerList(winning);
        Integer bonusNumber = toInteger(bonus);
        validateLottoNumberRange(bonusNumber);
        validateWinningNumbersNotContainBonusNumber(winningNumbers, bonusNumber);
    }

    private static void validateWinningNumbersNotContainBonusNumber(List<Integer> lottoNumbers, Integer bonus) {
        if (lottoNumbers.contains(bonus)) {
            throw new IllegalArgumentException(INVALID_LOTTO_FORMAT_MESSAGE);
        }
    }
}
