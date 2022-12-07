package vendingmachine.view;

import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.toList;
import static vendingmachine.view.InputValidator.PRODUCTS_DELIMITER;
import static vendingmachine.view.InputValidator.PRODUCT_AMOUNT_INDEX;
import static vendingmachine.view.InputValidator.PRODUCT_DELIMITER;
import static vendingmachine.view.InputValidator.PRODUCT_NAME_INDEX;
import static vendingmachine.view.InputValidator.PRODUCT_QUANTITY_INDEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.ProductDto;

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

    public List<ProductDto> readProducts() {
        System.out.println(READ_PRODUCTS_MESSAGE);
        String products = Console.readLine();
        inputValidator.validateProducts(products);
        return toProducts(products);
    }

    private List<ProductDto> toProducts(String products) {
        return Arrays.stream(products.split(PRODUCTS_DELIMITER))
                .map(product -> product.split(PRODUCT_DELIMITER))
                .map(product -> new ProductDto(
                        product[PRODUCT_NAME_INDEX],
                        valueOf(product[PRODUCT_AMOUNT_INDEX]),
                        valueOf(product[PRODUCT_QUANTITY_INDEX])
                ))
                .collect(toList());
    }
}
