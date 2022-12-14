package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.controller.command.FrontControllerCommand;
import pairmatching.controller.command.RematchCommand;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.dto.InformationDto;

public class InputView {

    private static final String READ_FRONT_COMMAND = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private static final String READ_INFORMATION = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3:\n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5:\n"
            + "############################################\n"
            + "과정, 레벨, 미션을 선택하세요.";
    private static final String READ_REMATCH_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";
    private static final String INFORMATION_DELIMITER = ", ";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final InputValidator inputValidator = new InputValidator();

    public FrontControllerCommand readFrontControllerCommand() {
        System.out.println(READ_FRONT_COMMAND);
        String command = Console.readLine();
        return FrontControllerCommand.from(command);
    }

    public RematchCommand readRematchCommand() {
        System.out.println(READ_REMATCH_MESSAGE);
        String rematchCommand = Console.readLine();
        return RematchCommand.from(rematchCommand);
    }

    public InformationDto readInformation() {
        System.out.println(READ_INFORMATION);
        String information = Console.readLine();
        inputValidator.validateInformation(information);
        return toInformationDto(information);
    }

    private static InformationDto toInformationDto(String information) {
        String[] seperatedInformation = information.split(INFORMATION_DELIMITER);
        return new InformationDto(
                Course.from(seperatedInformation[COURSE_INDEX]),
                Level.from(seperatedInformation[LEVEL_INDEX]),
                seperatedInformation[MISSION_INDEX]
        );
    }
}
