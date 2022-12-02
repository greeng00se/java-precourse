package racingcar.domain;

public class PlayCount {

    private static final int MINIMUM_COUNT = 0;

    private Integer count;

    public PlayCount(Integer count) {
        this.count = count;
    }

    public void decrease() {
        if (!isPlayable()) {
            return;
        }
        count--;
    }

    public boolean isPlayable() {
        return count > MINIMUM_COUNT;
    }
}
