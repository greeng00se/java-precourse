package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.CommandDto;
import pairmatching.dto.InformationDto;
import pairmatching.dto.RematchCommandDto;

public class InputView {

    private static final String READ_COMMAND_MESSAGE = "\n기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private static final String READ_INFORMATION_MESSAGE = "\n#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3:\n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5:\n"
            + "############################################\n"
            + "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    private static final String INFORMATION_DELIMITER = ", ";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String READ_REMATCH_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";

    private final InputValidator inputValidator = new InputValidator();

    public CommandDto readCommand() {
        System.out.println(READ_COMMAND_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateCommand(command);
        return new CommandDto(command);
    }

    public RematchCommandDto readRematchCommand() {
        System.out.println(READ_REMATCH_MESSAGE);
        String rematchCommand = Console.readLine();
        inputValidator.validateRematchCommand(rematchCommand);
        return new RematchCommandDto(rematchCommand);
    }

    public InformationDto readInformation() {
        System.out.println(READ_INFORMATION_MESSAGE);
        String information = Console.readLine();
        inputValidator.validateInformation(information);
        return toInformationDto(information);
    }

    private InformationDto toInformationDto(String information) {
        String[] info = information.split(INFORMATION_DELIMITER);
        return new InformationDto(info[COURSE_INDEX], info[LEVEL_INDEX], info[MISSION_INDEX]);
    }
}
