package view;

import camp.nextstep.edu.missionutils.Console;
import command.FrontCommand;
import dto.OrderDto;

public enum InputView {
    INSTANCE;

    private static final String READ_FRONT_COMMAND = "## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료\n"
            + "## 원하는 기능을 선택하세요.";
    private static final String READ_TABLE_MESSAGE = "## 테이블을 선택하세요.";
    private static final String READ_MENU_MESSAGE = "## 등록할 메뉴를 선택하세요.";
    private static final String READ_QUANTITY_MESSAGE = "## 메뉴의 슈량을 입력하세요.";

    public FrontCommand readFrontCommand() {
        System.out.println(READ_FRONT_COMMAND);
        String command = Console.readLine();
        return FrontCommand.of(command);
    }

    public OrderDto readOrder() {
        System.out.println(READ_TABLE_MESSAGE);
        String table = Console.readLine();
        System.out.println(READ_MENU_MESSAGE);
        String menu = Console.readLine();
        System.out.println(READ_QUANTITY_MESSAGE);
        String quantity = Console.readLine();
        return new OrderDto(table, menu, quantity);
    }
}
