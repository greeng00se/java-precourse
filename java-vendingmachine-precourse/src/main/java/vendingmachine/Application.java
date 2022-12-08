package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Change;
import vendingmachine.domain.ChangeFactory;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService());
        vendingMachineController.run();
    }

    private static VendingMachineService vendingMachineService() {
        return new VendingMachineService(changeFactory(), vendingMachine());
    }

    private static ChangeFactory changeFactory() {
        return new ChangeFactory();
    }

    private static VendingMachine vendingMachine() {
        return new VendingMachine(change(), products());
    }

    private static Change change() {
        return new Change();
    }

    private static Products products() {
        return new Products();
    }
}
