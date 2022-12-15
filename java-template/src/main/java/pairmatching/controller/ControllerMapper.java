package pairmatching.controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.command.Command;

public class ControllerMapper {

    private final Map<Command, Controller> mapper = new HashMap<>();

    public void put(Command command, Controller controller) {
        mapper.put(command, controller);
    }

    public Controller get(Command command) {
        return mapper.get(command);
    }
}
