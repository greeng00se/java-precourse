package pairmatching.controller;

import static pairmatching.controller.Retry.execute;

import pairmatching.controller.command.ControllerMapper;
import pairmatching.controller.command.FrontControllerCommand;
import pairmatching.view.InputView;

public class FrontController implements Controller {

    private final InputView inputView = new InputView();

    private final ControllerMapper controllerMapper;

    public FrontController(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

    @Override
    public void run() {
        FrontControllerCommand command = execute(inputView::readFrontControllerCommand);
        while (command.isNotQuit()) {
            Controller controller = controllerMapper.get(command);
            execute(controller::run);
            command = execute(inputView::readFrontControllerCommand);
        }
    }
}
