package pairmatching.controller.command;

import java.util.EnumMap;
import java.util.Map;
import pairmatching.controller.Controller;

public class ControllerMapper {

    private final Map<FrontControllerCommand, Controller> mapper = new EnumMap<>(FrontControllerCommand.class);

    public void put(FrontControllerCommand command, Controller controller) {
        mapper.put(command, controller);
    }

    public Controller get(FrontControllerCommand command) {
        return mapper.get(command);
    }
}
