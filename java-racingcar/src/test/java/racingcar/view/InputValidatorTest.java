package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    private final InputValidator sut = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"names,hello, ", "", " , ", "hello,jackson", "hello,hello"})
    void validateCarNames_메서드는_요구사항에_맞지_않는_차_이름을_입력받으면_IllegalArgumentException을_던진다(String names) {
        assertThatThrownBy(() -> sut.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복이 없는 5이하의 이름이어야 하고 쉼표로 구분되어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni", "jay", "hello,pobi"})
    void validateCarNames_메서드는_5자이하_쉼표로_구분된_차_이름을_입력받으면_예외를_던지지_않는다(String names) {
        assertThatNoException().isThrownBy(() -> sut.validateCarNames(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "", " ", "0", "-1"})
    void validatePlayCount_메서드는_1이상의_숫자가_아닌_경우를_입력받으면_IllegalArgumentException을_던진다(String count) {
        assertThatThrownBy(() -> sut.validatePlayCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1이상의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100"})
    void validateCarNames_메서드는_1이상의_숫자를_입력받으면_예외를_던지지_않는다(String count) {
        assertThatNoException().isThrownBy(() -> sut.validatePlayCount(count));
    }
}
