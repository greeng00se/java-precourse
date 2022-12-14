package baseball.view;

import baseball.dto.BaseballNumbersDto;
import baseball.dto.GameStatusDto;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String READ_STATUS_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final InputValidator inputValidator = new InputValidator();

    public BaseballNumbersDto readBaseballNumbers() {
        System.out.println(READ_BASEBALL_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        inputValidator.validateBaseballNumbers(numbers);
        return new BaseballNumbersDto(numbers);
    }

    public GameStatusDto readStatusCommand() {
        System.out.println(READ_STATUS_COMMAND_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateStatusCommand(command);
        return new GameStatusDto(command);
    }
}
