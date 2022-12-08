package vendingmachine.dto;

public class BuyProductDto {

    private final String name;

    public BuyProductDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
