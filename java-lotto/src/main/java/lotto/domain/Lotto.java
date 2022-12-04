package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;

public class Lotto {

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
}
