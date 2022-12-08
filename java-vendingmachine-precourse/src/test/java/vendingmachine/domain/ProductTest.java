package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Product 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductTest {

    @Test
    void 생성자는_상품의_가격이_10원_단위가_아니라면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> new Product("물건", 1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 가격은 10원 단위여야 합니다.");
    }

    @Test
    void getPrice_메서드는_상품의_가격을_반환한다() {
        Product product = new Product("물건1", 1000);

        assertThat(product.getPrice()).isEqualTo(1000);
    }

    @ParameterizedTest
    @CsvSource({"1000, false", "999, true"})
    void isNotPurchasable_메서드는_입력값이_상품의_가격보다_낮은경우_참을_반환한다(int amount, boolean result) {
        Product product = new Product("물건", 1000);

        assertThat(product.isNotPurchasable(amount)).isEqualTo(result);
    }

    @Test
    void isSameName_메서드는_문자열을_입력받아_상품의_이름과_같은경우_true를_반환한다() {
        Product product = new Product("물건", 1000);

        assertThat(product.isSameName("물건")).isTrue();
    }

}
