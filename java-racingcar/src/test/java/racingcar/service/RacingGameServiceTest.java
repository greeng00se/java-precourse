package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.NumberGenerator;
import racingcar.dto.CarNamesDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.PlayCountDto;
import racingcar.dto.PlayResultDto;

@DisplayName("RacingGameService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameServiceTest {

    private RacingGameService sut;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        numberGenerator = new TestNumberGenerator(newArrayList(5, 1));
        sut = new RacingGameService(numberGenerator);

        CarNamesDto carNamesDto = new CarNamesDto("car1,car2");
        PlayCountDto playCountDto = new PlayCountDto("1");
        sut.setupRacingGame(carNamesDto, playCountDto);
    }

    @Test
    void setup_메서드는_자동차_이름과_게임_실행_횟수를_받아_게임을_진행가능한_상태로_만든다() {
        RacingGameService racingGameService = new RacingGameService(numberGenerator);
        CarNamesDto carNamesDto = new CarNamesDto("car1,car2");
        PlayCountDto playCountDto = new PlayCountDto("1");

        racingGameService.setupRacingGame(carNamesDto, playCountDto);

        assertThat(racingGameService.isPlayable()).isTrue();
    }

    @Test
    void isPlayable_메서드는_게임_진행_가능여부를_반환한다() {
        boolean result = sut.isPlayable();

        assertThat(result).isTrue();
    }

    @Test
    void race_메서드는_게임을_진행하고_게임_결과를_반환한다() {
        PlayResultDto playResultDto = sut.race();

        assertThat(playResultDto.getCars()).hasSize(2);
    }

    @Test
    void getWinners_메서드는_게임의_최종_우승자를_반환한다() {
        sut.race();

        GameResultDto winners = sut.getWinners();

        Assertions.assertThat(winners.getCars()).contains("car1");
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
