package baseball.view;

import java.util.List;

class InputValidator {

    private static final char BASEBALL_NUMBER_LOWER_BOUND = '1';
    private static final char BASEBALL_NUMBER_UPPER_BOUND = '9';
    private static final long VALID_BASEBALL_NUMBERS_SIZE = 3L;
    private static final String INVALID_BASEBALL_NUMBERS_MESSAGE = "중복되지 않은 1 ~ 9 사의 숫자 3개를 입력해주세요.";
    private static final List<String> VALID_STATUS_COMMAND = List.of("1", "2");
    private static final String INVALID_STATUS_COMMAND_MESSAGE = "1(재시작) 또는 2(종료)를 입력해주세요.";

    public void validateBaseballNumbers(String numbers) {
        if (VALID_BASEBALL_NUMBERS_SIZE != numbers.length() ||
                VALID_BASEBALL_NUMBERS_SIZE != countBaseballNumbers(numbers)) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBERS_MESSAGE);
        }
    }

    private long countBaseballNumbers(String numbers) {
        return numbers.chars()
                .filter(this::isValidBaseballNumberRange)
                .distinct()
                .count();
    }

    private boolean isValidBaseballNumberRange(int number) {
        return BASEBALL_NUMBER_LOWER_BOUND <= number && number <= BASEBALL_NUMBER_UPPER_BOUND;
    }

    public void validateStatusCommand(String command) {
        if (!VALID_STATUS_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_STATUS_COMMAND_MESSAGE);
        }
    }
}
