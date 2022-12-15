package pairmatching.util;

import java.util.function.Function;
import java.util.function.Supplier;
import pairmatching.view.OutputView;

public class Retry {

    private static final int RETRY_COUNT = 3;
    private static final String RETRY_FAIL_MESSAGE = "기능을 수행할 수 없습니다.";
    private static final OutputView outputView = OutputView.INSTANCE;

    public static <T> T execute(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return execute(supplier);
        }
    }

    public static void execute(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            execute(runnable);
        }
    }

    public static <T, R> R execute(Function<T, R> service, T parameter) {
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                return service.apply(parameter);
            } catch (RuntimeException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
        throw new IllegalArgumentException(RETRY_FAIL_MESSAGE);
    }
}
