package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final long LOTTO_AMOUNT = 1000L;
    private static final int VALID_LOTTO_SIZE = 6;
    private static final String INVALID_LOTTO_SIZE_MESSAGE = "로또 번호는 중복되지 않은 6개의 숫자여야 합니다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = from(numbers);
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != VALID_LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private List<LottoNumber> from(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(toList());
    }

    public LottoPrize check(Lotto lotto, LottoNumber bonusNumber) {
        int match = checkLotto(lotto);
        boolean bonusMatched = checkBonusNumber(bonusNumber);
        return LottoPrize.from(match, bonusMatched);
    }

    private int checkLotto(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private boolean checkBonusNumber(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(toList());
    }
}
