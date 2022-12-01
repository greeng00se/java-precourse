package racingcar.dto;

public class CarDto {

    private final String name;
    private final Integer move;

    public CarDto(String name, Integer move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }
}
