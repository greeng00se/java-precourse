package vendingmachine.service;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.ChangeFactory;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.dto.AmountDto;
import vendingmachine.dto.BuyProductDto;
import vendingmachine.dto.ChangeBackDto;
import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.ProductDto;

public class VendingMachineService {

    private final ChangeFactory changeFactory;
    private final VendingMachine vendingMachine;

    public VendingMachineService(ChangeFactory changeFactory, VendingMachine vendingMachine) {
        this.changeFactory = changeFactory;
        this.vendingMachine = vendingMachine;
    }

    public ChangeDto fillChange(AmountDto changeAmount) {
        Map<Coin, Integer> change = changeFactory.generate(changeAmount.getAmount());
        vendingMachine.fillChange(change);
        return new ChangeDto(change);
    }

    public void fillProducts(List<ProductDto> productDtos) {
        Map<Product, Integer> products = productDtos.stream()
                .collect(toMap(ProductDto::to, ProductDto::getQuantity));
        vendingMachine.fillProduct(products);
    }

    public void putAmount(AmountDto buyAmount) {
        vendingMachine.putAmount(buyAmount.getAmount());
    }

    public void buyProduct(BuyProductDto buyProductDto) {
        vendingMachine.buy(buyProductDto.getName());
    }

    public ChangeBackDto changeBack() {
        return new ChangeBackDto(vendingMachine.getAmount(), vendingMachine.getChange());
    }

    public boolean isPurchasable() {
        return vendingMachine.isPurchasable();
    }

    public AmountDto getRemainAmount() {
        return new AmountDto(vendingMachine.getAmount());
    }
}
