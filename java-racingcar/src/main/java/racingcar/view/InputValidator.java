package racingcar.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String WHITE_SPACE = " ";
    private static final int CAR_NAME_UPPER_BOUND = 5;
    private static final String INVALID_CAR_NAME_MESSAGE = "차 이름은 중복이 없는 5이하의 이름이어야 하고 쉼표로 구분되어야 합니다.";
    private static final int PLAY_COUNT_LOWER_BOUND = 1;
    private static final String INVALID_PLAY_COUNT_MESSAGE = "이동 횟수는 1이상의 숫자여야 합니다.";

    public void validateCarNames(String names) {
        List<String> carNames = toCarNames(names);
        if (carNames.size() != countValidNames(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private List<String> toCarNames(String names) {
        return Arrays.stream(names.split(CAR_NAMES_DELIMITER))
                .collect(toList());
    }

    private int countValidNames(List<String> carNames) {
        return (int) carNames.stream()
                .filter(this::isValidCarName)
                .distinct()
                .count();
    }

    private boolean isValidCarName(String name) {
        return !name.isBlank() && !name.contains(WHITE_SPACE) && name.length() <= CAR_NAME_UPPER_BOUND;
    }

    public void validatePlayCount(String count) {
        Integer playCount = toInteger(count);
        if (isInvalidPlayCountRange(playCount)) {
            throw new IllegalArgumentException(INVALID_PLAY_COUNT_MESSAGE);
        }
    }

    private Integer toInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PLAY_COUNT_MESSAGE);
        }
    }

    private boolean isInvalidPlayCountRange(Integer playCount) {
        return playCount < PLAY_COUNT_LOWER_BOUND;
    }
}
