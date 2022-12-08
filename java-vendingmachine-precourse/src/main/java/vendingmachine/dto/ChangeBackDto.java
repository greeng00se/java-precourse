package vendingmachine.dto;

import java.util.Map;
import vendingmachine.domain.Coin;

public class ChangeBackDto {

    private final Integer amount;
    private final Map<Coin, Integer> change;

    public ChangeBackDto(Integer amount, Map<Coin, Integer> change) {
        this.amount = amount;
        this.change = change;
    }

    public String getAmount() {
        return amount.toString();
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }
}
