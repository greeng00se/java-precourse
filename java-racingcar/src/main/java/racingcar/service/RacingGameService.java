package racingcar.service;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.PlayCount;
import racingcar.domain.RacingGame;
import racingcar.dto.CarDto;
import racingcar.dto.CarNamesDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.PlayCountDto;
import racingcar.dto.PlayResultDto;

public class RacingGameService {

    private final NumberGenerator numberGenerator;
    private RacingGame racingGame;

    public RacingGameService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void setupRacingGame(CarNamesDto carNamesDto, PlayCountDto playCountDto) {
        Cars cars = new Cars(carNamesDto.getCarNames());
        PlayCount playCount = new PlayCount(playCountDto.getPlayCount());
        racingGame = new RacingGame(cars, playCount, numberGenerator);
    }

    public PlayResultDto race() {
        racingGame.race();
        return racingGame.getPlayResult().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(collectingAndThen(toList(), PlayResultDto::new));
    }

    public GameResultDto getWinners() {
        return new GameResultDto(racingGame.getWinners());
    }

    public boolean isPlayable() {
        if (racingGame == null) {
            return false;
        }
        return racingGame.isGamePlayable();
    }
}
