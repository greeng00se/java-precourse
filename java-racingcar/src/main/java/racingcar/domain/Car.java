package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int MOVE_VALUE_LOWER_BOUND = 4;
    private static final int NAME_SIZE_UPPER_BOUND = 5;
    private static final String INVALID_NAME_SIZE_MESSAGE = "이름의 길이는 5 이하여야 합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validate(String name) {
        if (name.length() > NAME_SIZE_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }

    public void move(Integer value) {
        if (value >= MOVE_VALUE_LOWER_BOUND) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }
}
