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
import pairmatching.service.PairMatchingCommandService;
import pairmatching.service.PairMatchingQueryService;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Controller pairMatchingController = new FrontController(controllerMapper());
        pairMatchingController.run();
    }

    private static ControllerMapper controllerMapper() {
        ControllerMapper mapper = new ControllerMapper();
        mapper.put(MATCHING, new MatchingController(pairMatchingQueryService(), pairMatchingCommandService()));
        mapper.put(SEARCH, new SearchController());
        mapper.put(RESET, new ResetController());
        mapper.put(QUIT, () -> {
        });
        return mapper;
    }

    private static PairMatchingQueryService pairMatchingQueryService() {
        return new PairMatchingQueryService();
    }

    private static PairMatchingCommandService pairMatchingCommandService() {
        return new PairMatchingCommandService();
    }
}
