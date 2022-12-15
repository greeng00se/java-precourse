package pairmatching.config;

import pairmatching.command.FrontCommand;
import pairmatching.controller.ControllerMapper;
import pairmatching.controller.MatchingController;
import pairmatching.controller.ResetController;
import pairmatching.controller.SearchController;
import pairmatching.repository.CrewRepository;
import pairmatching.service.MatchingService;
import pairmatching.util.CrewFileReader;

public class AppConfig {

    public static ControllerMapper controllerMapper() {
        ControllerMapper controllerMapper = new ControllerMapper();
        controllerMapper.put(FrontCommand.MATCHING, matchingController());
        controllerMapper.put(FrontCommand.SEARCH, searchController());
        controllerMapper.put(FrontCommand.RESET, resetController());
        controllerMapper.put(FrontCommand.QUIT, () -> {
        });
        return controllerMapper;
    }

    private static MatchingController matchingController() {
        return new MatchingController(matchingService());
    }

    private static MatchingService matchingService() {
        return new MatchingService(crewRepository());
    }

    private static CrewRepository crewRepository() {
        CrewRepository crewRepository = new CrewRepository();
        crewRepository.saveAll(CrewFileReader.readFrontend());
        crewRepository.saveAll(CrewFileReader.readBackend());
        return crewRepository;
    }

    private static SearchController searchController() {
        return new SearchController();
    }

    private static ResetController resetController() {
        return new ResetController();
    }
}
