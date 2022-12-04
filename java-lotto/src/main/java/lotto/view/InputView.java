package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.AmountDto;

public class InputView {

    private static final String READ_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final InputValidator inputValidator = new InputValidator();

    public AmountDto readBuyAmount() {
        System.out.println(READ_BUY_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        inputValidator.validateBuyAmount(amount);
        return new AmountDto(amount);
    }
}
