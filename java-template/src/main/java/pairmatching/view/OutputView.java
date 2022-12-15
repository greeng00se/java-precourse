package pairmatching.view;

public class OutputView {

    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    private static OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
