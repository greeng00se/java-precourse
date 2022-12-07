package vendingmachine.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int VALID_AMOUNT_REMAIN = 10;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바른 숫자 형식이 아닙니다.";
    private static final String INVALID_AMOUNT_FORMAT_MESSAGE = "금액은 10원 단위어야 합니다.";
    private static final Pattern VALID_PRODUCT_PATTERN = Pattern.compile("\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\]");
    public static final String PRODUCTS_DELIMITER = ";";
    public static final String PRODUCT_DELIMITER = ",";
    public static final int PRODUCT_NAME_INDEX = 0;
    public static final int PRODUCT_AMOUNT_INDEX = 1;
    public static final int PRODUCT_QUANTITY_INDEX = 2;
    private static final int SPLIT_INDEX = -1;
    private static final String INVALID_PRODUCT_FORMAT_MESSAGE = "상품 형식: [상품명,가격,수량] 여러 개인 경우 ;로 구분해야 합니다.";

    public void validateAmount(String value) {
        Integer amount = toInteger(value);
        validateAmountFormat(amount);
    }

    private Integer toInteger(String amount) {
        try {
            return Integer.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateAmountFormat(Integer amount) {
        if (amount % VALID_AMOUNT_REMAIN != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT_MESSAGE);
        }
    }

    public void validateProducts(String inputProducts) {
        List<String> products = toProducts(inputProducts);
        validateProductFormat(products);
        validateProductAmount(products);
    }

    private List<String> toProducts(String product) {
        return Arrays.stream(product.split(PRODUCTS_DELIMITER, SPLIT_INDEX))
                .collect(toList());
    }

    private void validateProductFormat(List<String> products) {
        if (isInvalidProducts(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_FORMAT_MESSAGE);
        }
    }

    private boolean isInvalidProducts(List<String> products) {
        return products.stream()
                .anyMatch(this::isInvalidProduct);
    }

    private boolean isInvalidProduct(String product) {
        return !VALID_PRODUCT_PATTERN.matcher(product).matches();
    }

    private void validateProductAmount(List<String> products) {
        products.stream()
                .map(this::toProductAmount)
                .forEach(this::validateAmountFormat);
    }

    private Integer toProductAmount(String product) {
        String productAmount = product.split(PRODUCT_DELIMITER, SPLIT_INDEX)[PRODUCT_AMOUNT_INDEX];
        return toInteger(productAmount);
    }
}
