package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("VendingMachine 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Products products;
    private Change change;

    @BeforeEach
    void setup() {
        change = new Change();
        products = new Products();
        vendingMachine = new VendingMachine(change, products);
    }

    @Test
    void fillChange_메서드는_거스름돈_정보가_담긴_Map을_입력받아_거스름돈을_채운다() {
        Map<Coin, Integer> givenChange = Map.of(COIN_500, 2, COIN_100, 7);

        vendingMachine.fillChange(givenChange);

        assertThat(change.calculateSum()).isEqualTo(1700);
    }

    @Test
    void fillProducts_메서드는_상품_정보가_담긴_Map을_입력받아_상품을_채운다() {
        Product product = new Product("상품", 1000);
        Map<Product, Integer> givenProducts = Map.of(product, 1);

        vendingMachine.fillProduct(givenProducts);

        assertThat(products.isProductExist()).isTrue();
    }

    @Test
    void putAmount_메서드는_금액을_입력받아_자판기에_돈을_투입한다() {
        vendingMachine.putAmount(1000);

        assertThat(vendingMachine.getAmount()).isEqualTo(1000);
    }

    @Test
    void isPurchasable_메서드는_현재_투입금액으로_상품을_구매가능한_경우_true를_반환한다() {
        Product product = new Product("상품", 1000);
        vendingMachine.fillProduct(Map.of(product, 1));
        vendingMachine.putAmount(1000);

        assertThat(vendingMachine.isPurchasable()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, 999", "0, 1000"})
    void isPurchasable_메서드는_상품이_없거나_돈이_부족한_경우_false를_반환한다(int count, int amount) {
        Product product = new Product("상품", 1000);
        vendingMachine.fillProduct(Map.of(product, count));
        vendingMachine.putAmount(amount);

        assertThat(vendingMachine.isPurchasable()).isFalse();
    }

    @Test
    void buy_메서드는_상품명을_입력받아_투입한_금액으로_물건을_구매한다() {
        Product product = new Product("상품", 1000);
        vendingMachine.fillProduct(Map.of(product, 1));
        vendingMachine.putAmount(1000);

        vendingMachine.buy("상품");

        assertThat(vendingMachine.getAmount()).isEqualTo(0);
    }

    @Test
    void getAmount_메서드는_자판기에_남아있는_금액을_반환한다() {
        vendingMachine.putAmount(2500);

        assertThat(vendingMachine.getAmount()).isEqualTo(2500);
    }

    @Test
    void getChange_메서드는_자판기에_남아있는_금액을_가지고있는_거스름돈으로_반환할_수_있는_만큼_반환한다() {
        Map<Coin, Integer> changes = Map.of(COIN_500, 1, COIN_100, 5, COIN_10, 17);
        vendingMachine.fillChange(changes);
        vendingMachine.putAmount(750);

        Map<Coin, Integer> result = vendingMachine.getChange();

        assertThat(result).containsExactlyInAnyOrderEntriesOf(
                Map.of(COIN_500, 1, COIN_100, 2, COIN_50, 0, COIN_10, 5)
        );
    }
}
