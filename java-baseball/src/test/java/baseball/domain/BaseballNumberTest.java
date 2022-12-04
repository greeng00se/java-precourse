package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BaseballNumber 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 1000})
    void valueOf_메서드는_올바르지_않은_입력값을_받으면_IllegalArgumentException을_던진다(int number) {
        Assertions.assertThatThrownBy(() -> BaseballNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구공은 1 ~ 9 사이의 값만 가질 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    void valueOf_메서드는_1부터_9사이의_값을_입력_받으면_BaseballNumber_인스턴스를_반환한다(int number) {
        BaseballNumber baseballNumber = BaseballNumber.valueOf(number);

        assertThat(baseballNumber).isInstanceOf(BaseballNumber.class);
    }
}
