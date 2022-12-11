package subway.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import subway.view.OutputView;

public class Retry {

    private static final OutputView outputView = new OutputView();

    public static <T> T execute(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return execute(supplier);
        }
    }
}
