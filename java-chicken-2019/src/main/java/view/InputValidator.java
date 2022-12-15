package view;

public class InputValidator {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바른 숫자 형식을 입력해주세요.";

    public void validateNumber(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }
}
