import static config.AppConfig.controllerMapper;

import controller.FrontController;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        FrontController frontController = new FrontController(controllerMapper());
        frontController.run();
    }
}
