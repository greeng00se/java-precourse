package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Products {

    private static final String INVALID_PRODUCT_MESSAGE = "상품이 존재하지 않습니다.";
    private static final String INVALID_AMOUNT_MESSAGE = "상품을 구매할 수 없습니다.";
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;

    private Map<Product, Integer> products = new HashMap<>();

    public Products() {
    }

    public Products(Map<Product, Integer> products) {
        this.products.putAll(products);
    }

    public void fillProduct(Map<Product, Integer> products) {
        for (Product product : products.keySet()) {
            this.products.merge(product, products.get(product), Integer::sum);
        }
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

    public Product buy(String name, Integer amount) {
        Product product = findProduct(name);
        Integer productCount = products.getOrDefault(product, ZERO);
        if (productCount.equals(ZERO) || product.isNotPurchasable(amount)) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
        products.put(product, productCount - ONE);
        return product;
    }

    private Product findProduct(String name) {
        return products.keySet().stream()
                .filter(product -> product.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT_MESSAGE));
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
