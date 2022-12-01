package racingcar.dto;

import java.util.List;

public class GameResultDto {

    private final List<String> cars;

    public GameResultDto(List<String> cars) {
        this.cars = cars;
    }

    public List<String> getCars() {
        return cars;
    }
}
