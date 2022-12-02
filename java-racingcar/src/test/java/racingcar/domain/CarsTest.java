package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자는_중복된_이름을_입력받는경우_IllegalArugmentException을_던진다() {
        Assertions.assertThatThrownBy(() -> new Cars(List.of("car1", "car1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다.");
    }

    @Test
    void race_메서드는_NumberGenerator를_입력받아_경기를_진행한다() {
        Cars cars = new Cars(List.of("car1", "car2"));
        NumberGenerator numberGenerator = mock(NumberGenerator.class);

        cars.race(numberGenerator);

        verify(numberGenerator, times(2)).generate();
    }

    @Test
    void getCars_메서드는_모든_차를_반환한다() {
        Cars cars = new Cars(List.of("car1", "car2"));

        assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    void getWinners_메서드는_우승한_차들을_이름을_반환한다() {
        Cars cars = new Cars(List.of("car1", "car2", "car3"));

        cars.race(new TestNumberGenerator(newArrayList(0, 5, 9)));

        assertThat(cars.getWinners()).containsExactly("car2", "car3");
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
