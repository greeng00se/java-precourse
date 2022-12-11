package pairmatching.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import pairmatching.view.OutputView;

public class Retry {

    private static final int REPEAT_COUNT = 3;
    private static final String REPEAT_FAIL_MESSAGE = "기능을 수행할 수 없습니다.";

    private static final OutputView outputView = new OutputView();

    public static <T> T execute(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return execute(supplier);
        }
    }

    public static <T, R> R execute(Function<T, R> service, T parameter) {
        for (int i = 0; i < REPEAT_COUNT; i++) {
            try {
                return service.apply(parameter);
            } catch (RuntimeException e) {
                outputView.printException(e.getMessage());
            }
        }
        throw new IllegalArgumentException(REPEAT_FAIL_MESSAGE);
    }
}
