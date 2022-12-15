package view;

import domain.Menu;
import dto.TableDto;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public enum OutputView {
    INSTANCE;

    private static final String PRINT_TABLE_MESSAGE = "\n## 테이블 목록";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| {0} |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ # ┘";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printTables(final TableDto tables) {
        System.out.println(PRINT_TABLE_MESSAGE);
        System.out.println(generateTopLines(tables.getTableSize()));
        System.out.println(generateTable(tables.getTableNumber()));
        System.out.println(generateBottomLines(tables.getOrderExists()));
    }

    private String generateTopLines(Integer tableSize) {
        return TOP_LINE.repeat(tableSize);
    }

    private String generateTable(List<Integer> tableNumbers) {
        return tableNumbers.stream()
                .map(number -> MessageFormat.format(TABLE_FORMAT, number.toString()))
                .collect(Collectors.joining());
    }

    private String generateBottomLines(List<Boolean> orderExists) {
        return orderExists.stream()
                .map(this::generateBottomLine)
                .collect(Collectors.joining());
    }

    private String generateBottomLine(Boolean orderExists) {
        if (orderExists) {
            return BOTTOM_LINE_ORDERED;
        }
        return BOTTOM_LINE;
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
