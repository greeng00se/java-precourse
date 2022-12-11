package subway;

import static subway.config.AppConfig.edgeRepository;
import static subway.config.AppConfig.stationRepository;

import subway.controller.SubwayController;
import subway.service.PathFindService;

public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = new SubwayController(pathFindService());
        subwayController.run();
    }

    private static PathFindService pathFindService() {
        return new PathFindService(edgeRepository(), stationRepository());
    }
}
