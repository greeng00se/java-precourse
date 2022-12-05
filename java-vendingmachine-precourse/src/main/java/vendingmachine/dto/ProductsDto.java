package vendingmachine.dto;

public class ProductsDto {

    private final String products;

    public ProductsDto(String products) {
        this.products = products;
    }

    public String getProducts() {
        return products;
    }
}
