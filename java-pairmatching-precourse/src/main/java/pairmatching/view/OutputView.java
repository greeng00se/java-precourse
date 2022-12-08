package pairmatching.view;

import java.util.stream.Collectors;
import pairmatching.domain.Pair;
import pairmatching.dto.PairMatchingDto;

public class OutputView {

    private static final String PAIR_MATCHING_RESULT_MESSAGE = "\n페어 매칭 결과입니다.";
    private static final String PAIR_MATCHING_MESSAGE_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final String RESET_MESSAGE = "\n초기화 되었습니다.";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printPairMatchingResult(PairMatchingDto pairMatchingDto) {
        System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
        System.out.println(generateMatchingResults(pairMatchingDto));
    }

    private String generateMatchingResults(PairMatchingDto pairMatchingDto) {
        return pairMatchingDto.getPairs().stream()
                .map(this::generateMatchingResult)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String generateMatchingResult(Pair pair) {
        return pair.getCrewName().stream()
                .collect(Collectors.joining(PAIR_MATCHING_MESSAGE_DELIMITER));
    }

    public void printReset() {
        System.out.println(RESET_MESSAGE);
    }

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
