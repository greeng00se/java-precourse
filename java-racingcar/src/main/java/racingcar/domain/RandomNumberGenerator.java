package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MOVE_VALUE_LOWER_BOUND = 0;
    private static final int MOVE_VALUE_UPPER_BOUND = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MOVE_VALUE_LOWER_BOUND, MOVE_VALUE_UPPER_BOUND);
    }
}
