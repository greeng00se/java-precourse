package pairmatching.view;

public enum OutputView {
    INSTANCE;

    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
