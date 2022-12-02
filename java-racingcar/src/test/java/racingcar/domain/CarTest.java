package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 생성자는_길이가_5를_넘어가는_이름을_입력받으면_IllegalArgumentExcpetion을_던진다() {
        assertThatThrownBy(() -> new Car("GROOVY"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5 이하여야 합니다.");
    }

    @Test
    void 생성자는_길이가_5이하의_이름을_입력받으면_예외를_던지지_않는다() {
        assertThatNoException().isThrownBy(() -> new Car("TAKE"));
    }

    @Test
    void move_메서드는_4_이상의_값을_입력받으면_위치를_한_칸_전진한다() {
        Car car = new Car("MyCAR");

        car.move(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void getName_메서드는_이름을_반환한다() {
        Car car = new Car("MyCar");

        assertThat(car.getName()).isEqualTo("MyCar");
    }

    @Test
    void getPosition_메서드는_위치를_반환한다() {
        Car car = new Car("MyCar");

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void isSamePosition_메서드는_같은_위치에_있는_차를_입력받으면_true를_반환한다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        boolean result = car1.isSamePosition(car2);

        assertThat(result).isTrue();
    }

    @Test
    void isSamePosition_메서드는_다른_위치에_있는_차를_입력받으면_false를_반환한다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(5);

        boolean result = car1.isSamePosition(car2);

        assertThat(result).isFalse();
    }

    @Test
    void compareTo_메서드는_다른_차를_입력받아_위치를_비교한다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(5);

        int result = car1.compareTo(car2);

        assertThat(result).isPositive();
    }
}
