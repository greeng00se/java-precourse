package vendingmachine.dto;

public class AmountDto {

    private final String amount;

    public AmountDto(String amount) {
        this.amount = amount;
    }

    public AmountDto(Integer amount) {
        this.amount = amount.toString();
    }

    public Integer getAmount() {
        return Integer.valueOf(amount);
    }

    public String getStringAmount() {
        return amount;
    }
}
