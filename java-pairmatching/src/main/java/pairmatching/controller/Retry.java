package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.view.OutputView;

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

    public static void execute(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            execute(runnable);
        }
    }
}
