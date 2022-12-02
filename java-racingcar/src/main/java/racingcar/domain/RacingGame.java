package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final PlayCount playCount;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, PlayCount playCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.playCount = playCount;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        cars.race(numberGenerator);
        playCount.decrease();
    }

    public boolean isGamePlayable() {
        return playCount.isPlayable();
    }

    public List<Car> getPlayResult() {
        return cars.getCars();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
