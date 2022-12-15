package command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("FrontCommand Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FrontCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "GO"})
    void of_메서드는_올바르지_않은_커맨드를_입력하는경우_IllegalArugmentException을_던진다(String command) {
        Assertions.assertThatThrownBy(() -> FrontCommand.of(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 커맨드입니다.");
    }
}
