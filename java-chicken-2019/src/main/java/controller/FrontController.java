package controller;

import command.FrontCommand;
import util.Retry;
import view.InputView;

public class FrontController extends AbstractController {

    private final InputView inputView = InputView.INSTANCE;
    private final ControllerMapper controllerMapper;

    public FrontController(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

    @Override
    protected void process() {
        FrontCommand command = Retry.execute(inputView::readFrontCommand);
        while (command.isContinuous()) {
            Controller controller = controllerMapper.get(command);
            controller.run();
            command = Retry.execute(inputView::readFrontCommand);
        }
    }
}
