package baseball.domain;

import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_LOWER_BOUND;
import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_UPPER_BOUND;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

public class BaseballNumbersFactory {

    public BaseballNumbers generateBaseballNumbers() {
        return Stream.generate(() -> pickNumberInRange(BASEBALL_NUMBER_LOWER_BOUND, BASEBALL_NUMBER_UPPER_BOUND))
                .map(BaseballNumber::valueOf)
                .distinct()
                .limit(BaseballNumbers.VALID_BASEBALL_NUMBERS_SIZE)
                .collect(collectingAndThen(toList(), BaseballNumbers::new));
    }

    public BaseballNumbers generateBaseballNumbers(String numbers) {
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseballNumber::valueOf)
                .collect(collectingAndThen(toList(), BaseballNumbers::new));
    }
}
