package baseball.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
    @ValueSource(strings = {"", "12", "1234", "!231", "123a", "133"})
    void validateBaseballNumbers_메서드는_올바르지_않은_값을_입력받으면_IllegalArgumentException을_던진다(String numbers) {
        assertThatThrownBy(() -> sut.validateBaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 1 ~ 9 사의 숫자 3개를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "948", "528", "987"})
    void validateBaseballNumbers_메서드는_중복되지_않은_1부터_9사이의_숫자_3개를_입력받으면_Exception을_던지지_않는다(String numbers) {
        assertThatNoException().isThrownBy(() -> sut.validateBaseballNumbers(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ", "", " ", "asd"})
    void validateStatusCommand_메서드는_올바르지_않은_값을_입력받으면_IllegalArgumentException을_던진다(String numbers) {
        assertThatThrownBy(() -> sut.validateStatusCommand(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1(재시작) 또는 2(종료)를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateBaseballNumbers_메서드는_상태를_표현하는_1또는_2를_입력받으면_Exception을_던지지_않는다(String numbers) {
        assertThatNoException().isThrownBy(() -> sut.validateStatusCommand(numbers));
    }
}
