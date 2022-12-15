package view;

import camp.nextstep.edu.missionutils.Console;
import command.FrontCommand;

public enum InputView {
    INSTANCE;

    private static final String READ_FRONT_COMMAND = "\n## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료\n"
            + "## 원하는 기능을 선택하세요.";
    private static final String READ_TABLE_MESSAGE = "\n## 테이블을 선택하세요.";
    private static final String READ_MENU_MESSAGE = "\n## 등록할 메뉴를 선택하세요.";
    private static final String READ_QUANTITY_MESSAGE = "\n## 메뉴의 수량을 입력하세요.";
    private static final InputValidator inputValidator = new InputValidator();

    public FrontCommand readFrontCommand() {
        System.out.println(READ_FRONT_COMMAND);
        String command = Console.readLine();
        return FrontCommand.of(command);
    }

    public Integer readTable() {
        System.out.println(READ_TABLE_MESSAGE);
        String table = Console.readLine();
        inputValidator.validateNumber(table);
        return Integer.valueOf(table);
    }

    public Integer readMenu() {
        System.out.println(READ_MENU_MESSAGE);
        String menu = Console.readLine();
        inputValidator.validateNumber(menu);
        return Integer.valueOf(menu);
    }

    public Integer readQuantity() {
        System.out.println(READ_QUANTITY_MESSAGE);
        String quantity = Console.readLine();
        inputValidator.validateNumber(quantity);
        return Integer.valueOf(quantity);
    }
}
