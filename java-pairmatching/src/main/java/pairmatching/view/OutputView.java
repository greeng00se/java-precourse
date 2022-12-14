package pairmatching.view;

import pairmatching.dto.PairMatchingDto;

public class OutputView {

    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }

    public void printPairMatchingResult(PairMatchingDto pairMatchingDto) {

    }
}
