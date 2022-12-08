package vendingmachine.dto;

import java.util.Map;
import vendingmachine.domain.Coin;

public class ChangeDto {

    private final Map<Coin, Integer> change;

    public ChangeDto(Map<Coin, Integer> change) {
        this.change = change;
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }
}
