package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Products 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductsTest {

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false"})
    void isProductExist_메서드는_물품이_1개라도_존재하는_경우_참_없는_경우_거짓을_반환한다(int count, boolean result) {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, count));

        assertThat(products.isProductExist()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, true", "999, false"})
    void isGreaterThanOrEqualToMinPrice_메서드는_입력값이_물품의_최소값_이상인지_비교하여_참_거짓을_반환한다(int value, boolean result) {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, 1));

        assertThat(products.isGreaterThanOrEqualToMinPrice(value)).isEqualTo(result);
    }

}
