package lotto.view;

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
    @ValueSource(strings = {"!", " ", "천원", "만원"})
    void validateBuyAmount_메서드는_숫자형식의_입력값이_아닌경우_IllegalArgumentException을_던진다(String amount) {
        assertThatThrownBy(() -> sut.validateBuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자 형식이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "412", "1001", "999"})
    void validateBuyAmount_메서드는_1000원단위_입력값이_아닌경우_IllegalArgumentException을_던진다(String amount) {
        assertThatThrownBy(() -> sut.validateBuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1,000원 단위어야 합니다.");
    }
}
