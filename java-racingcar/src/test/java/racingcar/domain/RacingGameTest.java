package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGame 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    private Cars cars;
    private RacingGame sut;

    @BeforeEach
    void setup() {
        cars = new Cars(List.of("car1", "car2"));
        PlayCount playCount = new PlayCount(1);
        NumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 5));
        sut = new RacingGame(cars, playCount, numberGenerator);
    }

    @Test
    void race_메서드는_게임을_진행한다() {
        sut.race();

        assertThat(cars.getWinners()).hasSize(1);
    }

    @Test
    void isPlayable_메서드는_게임_진행이_가능한지_여부를_반환한다() {
        boolean result = sut.isGamePlayable();

        assertThat(result).isTrue();
    }

    @Test
    void getPlayResult는_Car_리스트를_반환한다() {
        List<Car> result = sut.getPlayResult();

        assertThat(result).hasSize(2);
    }

    @Test
    void getWinners_메서드는_우승자_이름을_반환한다() {
        sut.race();

        assertThat(sut.getWinners()).contains("car2");
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
