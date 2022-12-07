package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.ProductsDto;

public class InputView {

    private static final String READ_HOLD_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String READ_BUY_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String READ_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

    private final InputValidator inputValidator = new InputValidator();

    public AmountDto readHoldAmount() {
        System.out.println(READ_HOLD_AMOUNT_MESSAGE);
        return readAmount();
    }

    public AmountDto readBuyAmount() {
        System.out.println(READ_BUY_AMOUNT_MESSAGE);
        return readAmount();
    }

    private AmountDto readAmount() {
        String amount = Console.readLine();
        inputValidator.validateAmount(amount);
        return new AmountDto(amount);
    }

    public ProductsDto readProducts() {
        System.out.println(READ_PRODUCTS_MESSAGE);
        String products = Console.readLine();
        inputValidator.validateProducts(products);
        return new ProductsDto(products);
    }
}
