package racingcar.dto;

import java.util.List;

public class PlayResultDto {

    List<CarDto> cars;

    public PlayResultDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
