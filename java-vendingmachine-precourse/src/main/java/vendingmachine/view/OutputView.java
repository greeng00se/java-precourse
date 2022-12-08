package vendingmachine.view;

import static java.text.MessageFormat.format;

import java.text.MessageFormat;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.ChangeBackDto;
import vendingmachine.dto.ChangeDto;

public class OutputView {

    private static final String CHANGE_MESSAGE = "\n자판기가 보유한 동전";
    private static final String CHANGE_MESSAGE_FORMAT = "{0}원 - {1}개";
    private static final String AMOUNT_MESSAGE_FORMAT = "\n투입 금액: {0}원";
    private static final String EMPTY_MESSAGE = "";
    private static final String NEW_LINE = "\n";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";
    private static final int ZERO = 0;

    public void printChange(ChangeDto changeDto) {
        Map<Coin, Integer> change = changeDto.getChange();
        System.out.println(CHANGE_MESSAGE);
        for (Coin coin : Coin.descendingOrder()) {
            System.out.println(format(CHANGE_MESSAGE_FORMAT, coin.getAmount(), change.getOrDefault(coin, ZERO)));
        }
    }

    public void printAmount(AmountDto amountDto) {
        System.out.println(format(AMOUNT_MESSAGE_FORMAT, amountDto.getStringAmount()));
    }

    public void printChangeBackAmount(ChangeBackDto resultDto) {
        System.out.println(format(AMOUNT_MESSAGE_FORMAT, resultDto.getAmount()));
        System.out.println(printChangeResultMessage(resultDto));
    }

    private String printChangeResultMessage(ChangeBackDto resultDto) {
        Map<Coin, Integer> change = resultDto.getChange();
        StringBuilder result = new StringBuilder();
        for (Coin coin : Coin.descendingOrder()) {
            result.append(generateChangeMessage(change, coin) + NEW_LINE);
        }
        return result.toString();
    }

    private static String generateChangeMessage(Map<Coin, Integer> change, Coin coin) {
        Integer count = change.getOrDefault(coin, ZERO);
        if (count == ZERO) {
            return EMPTY_MESSAGE;
        }
        return MessageFormat.format(CHANGE_MESSAGE_FORMAT, coin.getAmount(), count);
    }

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
