package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;

public class Cars {

    private static final String DUPLICATED_NAME_MESSAGE = "차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validate(carNames);
        this.cars = toCars(carNames);
    }

    private void validate(List<String> carNames) {
        HashSet<String> nonDuplicatedCarNames = new HashSet<>(carNames);
        if (carNames.size() != nonDuplicatedCarNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private List<Car> toCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void race(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(toList());
    }

    private Car getWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }
}
