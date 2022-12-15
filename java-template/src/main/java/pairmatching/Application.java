package pairmatching;

import static pairmatching.config.AppConfig.controllerMapper;

import pairmatching.controller.Controller;
import pairmatching.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        Controller frontController = new FrontController(controllerMapper());
        frontController.run();
    }
}
