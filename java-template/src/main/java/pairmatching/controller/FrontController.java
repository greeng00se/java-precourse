package pairmatching.controller;

import static pairmatching.util.Retry.execute;

import pairmatching.command.FrontCommand;
import pairmatching.view.InputView;

public class FrontController extends AbstractController {

    private final InputView inputView = InputView.INSTANCE;
    private final ControllerMapper controllerMapper;

    public FrontController(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

    @Override
    protected void process() {
        FrontCommand command = execute(inputView::readFrontCommand);
        while (command.isContinuous()) {
            Controller controller = controllerMapper.get(command);
            controller.run();
            command = execute(inputView::readFrontCommand);
        }
    }
}
