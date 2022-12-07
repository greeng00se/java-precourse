package vendingmachine.dto;

import vendingmachine.domain.Product;

public class ProductDto {

    private final String name;
    private final Integer price;
    private final Integer quantity;

    public ProductDto(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product to() {
        return new Product(name, price);
    }

    public Integer getQuantity() {
        return quantity;
    }
}
