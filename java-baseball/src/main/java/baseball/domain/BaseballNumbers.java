package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballNumbers {

    public static final int VALID_BASEBALL_NUMBERS_SIZE = 3;
    private static final String INVALID_BASEBALL_NUMBERS_SIZE_MESSAGE = "올바른 BaseballNumbers 입력값이 아닙니다.";

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != VALID_BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBERS_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<BaseballNumber> baseballNumbers) {
        HashSet<BaseballNumber> nonDuplicateBaseballNumber = new HashSet<>(baseballNumbers);
        if (nonDuplicateBaseballNumber.size() != VALID_BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBERS_SIZE_MESSAGE);
        }
    }

    public BaseballGameResult play(BaseballNumbers other) {
        int strike = countStrike(other);
        int ball = countBall(other, strike);

        return BaseballGameResult.from(ball, strike);
    }

    private int countStrike(BaseballNumbers other) {
        return (int) IntStream.range(0, VALID_BASEBALL_NUMBERS_SIZE)
                .filter(i -> this.baseballNumbers.get(i) == other.baseballNumbers.get(i))
                .count();
    }

    private int countBall(BaseballNumbers other, int strike) {
        return (int) other.baseballNumbers.stream()
                .filter(baseballNumber -> this.baseballNumbers.contains(baseballNumber))
                .count() - strike;
    }
}
