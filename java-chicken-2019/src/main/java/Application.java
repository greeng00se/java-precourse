import command.FrontCommand;
import controller.ControllerMapper;
import controller.FrontController;
import controller.OrderController;
import controller.PaymentController;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.TableRepository;
import service.SearchService;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        FrontController frontController = new FrontController(controllerMapper());
        frontController.run();
    }

    private static ControllerMapper controllerMapper() {
        ControllerMapper controllerMapper = new ControllerMapper();
        controllerMapper.put(FrontCommand.ORDER, orderController());
        controllerMapper.put(FrontCommand.PAYMENT, new PaymentController());
        controllerMapper.put(FrontCommand.QUIT, () -> {
        });
        return controllerMapper;
    }

    private static OrderController orderController() {
        return new OrderController(searchService());
    }

    private static SearchService searchService() {
        return new SearchService(menuRepository(), tableRepository(), orderRepository());
    }

    private static MenuRepository menuRepository() {
        return new MenuRepository();
    }

    private static TableRepository tableRepository() {
        return new TableRepository();
    }

    private static OrderRepository orderRepository() {
        return new OrderRepository();
    }
}
