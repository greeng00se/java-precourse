package pairmatching.view;

import java.util.List;
import java.util.regex.Pattern;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InputValidator {

    private static final List<String> VALID_COMMAND = List.of("1", "2", "3", "Q");
    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다";
    private static final Pattern VALID_INFORMATION_PATTERN = Pattern.compile("[가-힇]*, [가-힇0-9]*, [가-힇]*");
    private static final String INVALID_INFORMATION_MESSAGE = "올바른 과정, 레벨, 미션 형식의 정보를 입력해주세요.";
    private static final String INFORMATION_DELIMITER = ", ";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    public void validateCommand(String command) {
        if (!VALID_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }

    public void validateInformation(String information) {
        if (!VALID_INFORMATION_PATTERN.matcher(information).matches()) {
            throw new IllegalArgumentException(INVALID_INFORMATION_MESSAGE);
        }
        String[] info = information.split(INFORMATION_DELIMITER);
        validateCourse(info[COURSE_INDEX]);
        validateLevel(info[LEVEL_INDEX]);
        validateMission(info[MISSION_INDEX]);
    }

    private void validateCourse(String course) {
        if (!Course.names().contains(course)) {
            throw new IllegalArgumentException(INVALID_INFORMATION_MESSAGE);
        }
    }

    private void validateLevel(String level) {
        if (!Level.names().contains(level)) {
            throw new IllegalArgumentException(INVALID_INFORMATION_MESSAGE);
        }
    }

    private void validateMission(String mission) {
    }
}
