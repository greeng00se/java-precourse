package pairmatching.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
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

    @ParameterizedTest
    @ValueSource(strings = {
            "백엔드, 레벨1",
            "프론트엔드, 레벨6, 오징어게임",
            " , , "
    })
    void validateInformation_메서드는_올바른_입력양식이_아니라면_IllegalArguementExcpetion을_던진다(String information) {
        Assertions.assertThatThrownBy(() -> sut.validateInformation(information))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 과정, 레벨, 미션 형식의 정보를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "백엔드, 레벨1, 오징어게임",
            "백엔드, 레벨2, 자동차경주",
    })
    void validateInformation_메서드는_올바른_과정_레벨_미션_정보를_입력하면_예외를_던지지_않는다(String information) {
        assertThatNoException().isThrownBy(() -> sut.validateInformation(information));
    }
}
