package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Products 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductsTest {

    @Test
    void fillProduct_메서드는_상품과_수량에대한_Map을_입력받아_상품을_채운다() {
        Products products = new Products();
        Product product = new Product("상품", 1000);

        products.fillProduct(Map.of(product, 1));

        assertThat(products.isProductExist()).isTrue();
    }

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

    @Test
    void buy_메서드는_구매할_상품명을_입력받아_구매를_진행한다() {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, 1));

        products.buy("물건", 1000);

        assertThat(products.isProductExist()).isFalse();
    }

    @Test
    void buy_메서드는_상품명과_금액을_입력받고_해당_상품이_없다면_IllegalArgumentException을_던진다() {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, 1));

        assertThatThrownBy(() -> products.buy("물건1", 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품이 존재하지 않습니다.");
    }

    @Test
    void buy_메서드는_상품명과_금액_입력받고_해당_상품이_재고가없다면_IllegalArgumentException을_던진다() {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, 0));

        assertThatThrownBy(() -> products.buy("물건", 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품을 구매할 수 없습니다.");
    }

    @Test
    void buy_메서드는_상품명과_금액_입력받고_금액이_부족하다면_IllegalArgumentException을_던진다() {
        Product product = new Product("물건", 1000);
        Products products = new Products(Map.of(product, 1));

        assertThatThrownBy(() -> products.buy("물건", 999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품을 구매할 수 없습니다.");
    }
}
