package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private Change change;
    private Products products;
    private Integer amount;

    public VendingMachine(Change change, Products products) {
        this(change, products, 0);
    }

    public VendingMachine(Change change, Products products, Integer amount) {
        this.change = change;
        this.products = products;
        this.amount = amount;
    }

    public void fillChange(Map<Coin, Integer> change) {
        this.change.fillChange(change);
    }

    public void fillProduct(Map<Product, Integer> products) {
        this.products.fillProduct(products);
    }

    public void putAmount(Integer amount) {
        this.amount += amount;
    }

    public boolean isPurchasable() {
        return products.isProductExist() && products.isGreaterThanOrEqualToMinPrice(amount);
    }

    public void buy(String name) {
        Product product = products.buy(name, amount);
        amount -= product.getPrice();
    }

    public Integer getAmount() {
        return amount;
    }

    public Map<Coin, Integer> getChange() {
        return change.getChangeLessThanOrEqualTo(amount);
    }
}
