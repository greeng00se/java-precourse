package racingcar.dto;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CarNamesDto {

    private static final String CAR_NAMES_DELIMITER = ",";

    private final String carNames;

    public CarNamesDto(String carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return Arrays.stream(carNames.split(CAR_NAMES_DELIMITER))
                .collect(toList());
    }
}
