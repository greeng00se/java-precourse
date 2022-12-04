package lotto.dto;

public class AmountDto {

    private final String amount;

    public AmountDto(String amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return Integer.valueOf(amount);
    }
}
