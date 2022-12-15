import command.FrontCommand;
import controller.ControllerMapper;
import controller.FrontController;
import controller.OrderController;
import controller.PaymentController;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        FrontController frontController = new FrontController(controllerMapper());
        frontController.run();
    }

    private static ControllerMapper controllerMapper() {
        ControllerMapper controllerMapper = new ControllerMapper();
        controllerMapper.put(FrontCommand.ORDER, new OrderController());
        controllerMapper.put(FrontCommand.PAYMENT, new PaymentController());
        controllerMapper.put(FrontCommand.QUIT, () -> {
        });
        return controllerMapper;
    }
}
