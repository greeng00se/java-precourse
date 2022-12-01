package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNamesDto;
import racingcar.dto.PlayCountDto;

public class InputView {

    private static final String READ_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputValidator inputValidator = new InputValidator();

    public CarNamesDto readRacingCarNames() {
        System.out.println(READ_RACING_CAR_NAMES_MESSAGE);
        String names = Console.readLine();
        inputValidator.validateCarNames(names);
        return new CarNamesDto(names);
    }

    public PlayCountDto readPlayCount() {
        System.out.println(READ_PLAY_COUNT_MESSAGE);
        String count = Console.readLine();
        inputValidator.validatePlayCount(count);
        return new PlayCountDto(count);
    }
}
