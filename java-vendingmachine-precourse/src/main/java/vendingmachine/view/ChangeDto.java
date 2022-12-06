package vendingmachine.view;

import java.util.EnumMap;
import vendingmachine.domain.Coin;

public class ChangeDto {

    private final EnumMap<Coin, Integer> change;

    public ChangeDto(EnumMap<Coin, Integer> change) {
        this.change = change;
    }

    public EnumMap<Coin, Integer> getChange() {
        return change;
    }
}
