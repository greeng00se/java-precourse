package vendingmachine.view;

import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.BuyProductDto;
import vendingmachine.dto.ProductDto;

public class InputView {

    private static final String READ_HOLD_AMOUNT_MESSAGE = "\n자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String READ_INPUT_AMOUNT_MESSAGE = "\n투입 금액을 입력해 주세요.";
    private static final String READ_BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";
    private static final String READ_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String PRODUCTS_DELIMITER = ";";
    private static final String PRODUCT_DELIMITER = ",";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_AMOUNT_INDEX = 1;
    private static final int PRODUCT_QUANTITY_INDEX = 2;
    private static final String PRODUCT_TIE_REGEX = "[\\[\\]]";
    private static final String EMPTY_STRING = "";

    private final InputValidator inputValidator = new InputValidator();

    public AmountDto readChangeAmount() {
        System.out.println(READ_HOLD_AMOUNT_MESSAGE);
        return readAmount();
    }

    public AmountDto readBuyAmount() {
        System.out.println(READ_INPUT_AMOUNT_MESSAGE);
        return readAmount();
    }

    private AmountDto readAmount() {
        String amount = Console.readLine();
        inputValidator.validateAmount(amount);
        return new AmountDto(amount);
    }

    public BuyProductDto readBuyProductName() {
        System.out.println(READ_BUY_PRODUCT_MESSAGE);
        String productName = Console.readLine();
        return new BuyProductDto(productName);
    }

    public List<ProductDto> readProducts() {
        System.out.println(READ_PRODUCTS_MESSAGE);
        String products = Console.readLine();
        inputValidator.validateProducts(products);
        return toProducts(products);
    }

    private List<ProductDto> toProducts(String products) {
        return Arrays.stream(products.split(PRODUCTS_DELIMITER))
                .map(product -> product.replaceAll(PRODUCT_TIE_REGEX, EMPTY_STRING))
                .map(product -> product.split(PRODUCT_DELIMITER))
                .map(this::toProductDto)
                .collect(toList());
    }

    private ProductDto toProductDto(String[] product) {
        return new ProductDto(
                product[PRODUCT_NAME_INDEX],
                valueOf(product[PRODUCT_AMOUNT_INDEX]),
                valueOf(product[PRODUCT_QUANTITY_INDEX])
        );
    }
}
