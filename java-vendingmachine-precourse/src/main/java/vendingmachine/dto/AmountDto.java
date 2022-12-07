package vendingmachine.dto;

public class AmountDto {

    private final String amount;

    public AmountDto(String amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return Integer.valueOf(amount);
    }
}
