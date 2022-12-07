package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Product 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductTest {

    @Test
    void 생성자는_상품의_가격이_10원_단위가_아니라면_IllegalArgumentException을_던진다() {
        Assertions.assertThatThrownBy(() -> new Product("물건", 1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 가격은 10원 단위여야 합니다.");
    }

    @Test
    void getPrice_메서드는_물품의_가격을_반환한다() {
        Product product = new Product("물건1", 1000);

        assertThat(product.getPrice()).isEqualTo(1000);
    }

}
