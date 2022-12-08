package vendingmachine.domain;

import java.util.Objects;

public class Product {

    private static final int VALID_PRICE_REMAIN = 10;
    private static final int ZERO = 0;
    private static final String INVALID_PRICE_MESSAGE = "상품의 가격은 10원 단위여야 합니다.";

    private final String name;
    private final Integer price;

    public Product(String name, Integer price) {
        validate(price);
        this.name = name;
        this.price = price;
    }

    private void validate(Integer price) {
        if (price % VALID_PRICE_REMAIN != ZERO) {
            throw new IllegalArgumentException(INVALID_PRICE_MESSAGE);
        }
    }

    public boolean isNotPurchasable(Integer amount) {
        return price > amount;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
