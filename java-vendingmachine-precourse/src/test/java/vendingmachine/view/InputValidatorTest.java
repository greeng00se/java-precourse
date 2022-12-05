package vendingmachine.view;

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
    @ValueSource(strings = {"!", "", "1001", "999"})
    void validateAmount_메서드는_10원단위_숫자형식이_아닌경우_IllegalArgumentException를_던진다(String amount) {
        assertThatThrownBy(() -> sut.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2500", "1000", "990"})
    void validateAmount_메서드는_10원단위_숫자형식인_경우_예외를_던지지_않는다(String amount) {
        assertThatNoException().isThrownBy(() -> sut.validateAmount(amount));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "[10,1]",
            "",
            "[상품,1,10]",
            "[상품,1000,10];[상품,2000,]",
            "[,1000,10];[상품,2000,10]",
            "[상품,1000,10];[상품2,2000,]",
            "[상품,1000,10];[,2000,1]",
            "[상품,1000,10][1,2000,1]",
            "[상품,1000,10];[5,2000,-1]",
            "[상품,1000,0];[상품2,2000,10];"
    })
    void validateProducts_메서드는_올바른_상품형식이_아닌경우_IllegalArgumentException를_던진다(String products) {
        assertThatThrownBy(() -> sut.validateProducts(products))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
