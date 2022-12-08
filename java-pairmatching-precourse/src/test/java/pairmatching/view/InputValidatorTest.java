package pairmatching.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    private final InputValidator sut = new InputValidator();

    @Test
    void validateCommand_메서드는_올바르지_않은_커맨드를_입력하면_IllegalArgumentException를_던진다() {
        assertThatThrownBy(() -> sut.validateCommand("4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 커맨드입니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "Q"})
    void validateCommand_메서드는_올바르지_커맨드를_입력하면_예외를_던지지_않는다(String command) {
        assertThatNoException().isThrownBy(() -> sut.validateCommand(command));
    }
}
