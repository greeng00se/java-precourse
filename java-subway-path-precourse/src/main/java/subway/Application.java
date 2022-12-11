package subway;

import java.util.HashMap;
import java.util.Map;
import subway.controller.LogicCommand;
import subway.controller.SubwayController;
import subway.service.PathFindService;
import subway.service.ShortestDistanceService;
import subway.service.ShortestTimeService;

public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = new SubwayController(pathFindServiceMap());
        subwayController.run();
    }

    private static Map<LogicCommand, PathFindService> pathFindServiceMap() {
        HashMap<LogicCommand, PathFindService> result = new HashMap<>();
        result.put(LogicCommand.DISTANCE, shortestDistanceService());
        result.put(LogicCommand.TIME, shortestTimeService());
        return result;
    }

    private static PathFindService shortestDistanceService() {
        return new ShortestDistanceService();
    }

    private static PathFindService shortestTimeService() {
        return new ShortestTimeService();
    }
}
