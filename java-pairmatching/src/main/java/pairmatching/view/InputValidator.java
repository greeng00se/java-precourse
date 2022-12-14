package pairmatching.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern VALID_INFORMATION_PATTERN = Pattern.compile("[가-힇]+, [가-힇0-9]+, [가-힇]+");
    private static final String INVALID_INFORMATION_MESSAGE = "올바른 과정, 레벨, 미션 형식의 정보를 입력해주세요.";

    public void validateInformation(String information) {
        if (!VALID_INFORMATION_PATTERN.matcher(information).matches()) {
            throw new IllegalArgumentException(INVALID_INFORMATION_MESSAGE);
        }
    }
}
