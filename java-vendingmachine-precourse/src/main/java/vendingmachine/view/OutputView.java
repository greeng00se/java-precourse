package vendingmachine.view;

import java.text.MessageFormat;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.dto.ChangeDto;

public class OutputView {

    private static final String CHANGE_MESSAGE = "\n자판기가 보유한 동전";
    private static final String CHANGE_MESSAGE_FORMAT = "{0}원 - {1}개";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printChange(ChangeDto changeDto) {
        Map<Coin, Integer> change = changeDto.getChange();
        System.out.println(CHANGE_MESSAGE);
        for (Coin coin : Coin.descendingOrder()) {
            System.out.println(MessageFormat.format(CHANGE_MESSAGE_FORMAT, coin.getAmount(), change.get(coin)));
        }
    }

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
