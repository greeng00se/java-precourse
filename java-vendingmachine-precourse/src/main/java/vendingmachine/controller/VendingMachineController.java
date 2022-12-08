package vendingmachine.controller;

import java.util.List;
import java.util.function.Supplier;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.BuyProductDto;
import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.ProductDto;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void run() {
        fillChange();
        fillProducts();
        putBuyAmount();
        while (vendingMachineService.isPurchasable()) {
            buyProduct();
        }
        changeBack();
    }

    private void fillChange() {
        AmountDto changeAmount = repeat(inputView::readChangeAmount);
        ChangeDto changeDto = vendingMachineService.fillChange(changeAmount);
        outputView.printChange(changeDto);
    }

    private void fillProducts() {
        List<ProductDto> productDtos = repeat(inputView::readProducts);
        vendingMachineService.fillProducts(productDtos);
    }

    private void putBuyAmount() {
        AmountDto buyAmount = repeat(inputView::readBuyAmount);
        vendingMachineService.putAmount(buyAmount);
    }

    private void buyProduct() {
        try {
            outputView.printAmount(vendingMachineService.getRemainAmount());
            BuyProductDto buyProductDto = inputView.readBuyProductName();
            vendingMachineService.buyProduct(buyProductDto);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            buyProduct();
        }
    }

    private void changeBack() {
        outputView.printChangeBackAmount(vendingMachineService.changeBack());
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return repeat(inputReader);
        }
    }
}
