package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,",
            "1,2,3,4,5f,6",
            "1,2,3,4,47,6",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5",
            " 1,2,3,4,5,6",
            "1,,3,4,5,6",
            ",,3,4,5,6",
            "1, 2, 3, 4, 5, 6",
            ""
    })
    void validateWinningNumbers_메서드는_올바른_로또형식이_아닌경우_IllegalArgumentException을_던진다(String winningNumbers) {
        Assertions.assertThatThrownBy(() -> sut.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "46", "0", "!"})
    void validateBonusNumber_메서드는_올바른_로또형식이_아니거나_당첨번호와_중복인경우_IllegalArgumentException을_던진다(String number) {
        Assertions.assertThatThrownBy(() -> sut.validateBonusNumber(number, "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
