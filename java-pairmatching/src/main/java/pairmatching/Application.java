package pairmatching;

import static pairmatching.controller.command.FrontControllerCommand.MATCHING;
import static pairmatching.controller.command.FrontControllerCommand.QUIT;
import static pairmatching.controller.command.FrontControllerCommand.RESET;
import static pairmatching.controller.command.FrontControllerCommand.SEARCH;

import pairmatching.controller.Controller;
import pairmatching.controller.FrontController;
import pairmatching.controller.MatchingController;
import pairmatching.controller.ResetController;
import pairmatching.controller.SearchController;
import pairmatching.controller.command.ControllerMapper;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Controller pairMatchingController = new FrontController(controllerMapper());
        pairMatchingController.run();
    }

    private static ControllerMapper controllerMapper() {
        ControllerMapper controllerMapper = new ControllerMapper();
        controllerMapper.put(MATCHING, new MatchingController());
        controllerMapper.put(SEARCH, new SearchController());
        controllerMapper.put(RESET, new ResetController());
        controllerMapper.put(QUIT, () -> {
        });
        return controllerMapper;
    }
}
