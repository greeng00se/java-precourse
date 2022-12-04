package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.AmountDto;
import lotto.dto.WinningLottoDto;

public class InputView {

    private static final String READ_BUY_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private final InputValidator inputValidator = new InputValidator();

    public AmountDto readBuyAmount() {
        System.out.println(READ_BUY_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        inputValidator.validateBuyAmount(amount);
        return new AmountDto(amount);
    }

    public WinningLottoDto readWinningLotto() {
        String winningNumber = readWinningNumber();
        String bonusNumber = readBonusNumber(winningNumber);
        return new WinningLottoDto(winningNumber, bonusNumber);
    }

    private String readWinningNumber() {
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        inputValidator.validateWinningNumbers(winningNumber);
        return winningNumber;
    }

    private String readBonusNumber(String winningNumber) {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        inputValidator.validateBonusNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
}
