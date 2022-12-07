package vendingmachine.domain;

import java.util.Comparator;
import java.util.Map;

public class Products {

    private static final String INVALID_PRODUCT_MESSAGE = "상품이 존재하지 않습니다.";
    private static final Integer ZERO = 0;

    private Map<Product, Integer> products;

    public Products(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean isProductExist() {
        Integer productCount = products.values().stream()
                .reduce(ZERO, Integer::sum);
        return productCount > ZERO;
    }

    public boolean isGreaterThanOrEqualToMinPrice(Integer price) {
        Integer minValue = products.keySet().stream()
                .filter(product -> !products.getOrDefault(product, ZERO).equals(ZERO))
                .min(Comparator.comparingInt(Product::getPrice))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT_MESSAGE))
                .getPrice();
        return minValue <= price;
    }
}
