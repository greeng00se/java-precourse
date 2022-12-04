package baseball.domain;

import java.util.HashMap;

public class BaseballNumber {

    public static final int BASEBALL_NUMBER_LOWER_BOUND = 1;
    public static final int BASEBALL_NUMBER_UPPER_BOUND = 9;
    private static final HashMap<Integer, BaseballNumber> CACHE = new HashMap<>();
    private static final String INVALID_NUMBER_MESSAGE = "야구공은 1 ~ 9 사이의 값만 가질 수 있습니다.";

    private final Integer number;

    static {
        for (int i = BASEBALL_NUMBER_LOWER_BOUND; i <= BASEBALL_NUMBER_UPPER_BOUND; i++) {
            CACHE.put(i, new BaseballNumber(i));
        }
    }

    private BaseballNumber(Integer number) {
        this.number = number;
    }

    public static BaseballNumber valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < BASEBALL_NUMBER_LOWER_BOUND || BASEBALL_NUMBER_UPPER_BOUND < number) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}
