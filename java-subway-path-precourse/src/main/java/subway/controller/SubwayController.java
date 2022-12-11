package subway.controller;

import subway.dto.CommandDto;
import subway.dto.PathDto;
import subway.dto.ResultDto;
import subway.service.PathFindService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PathFindService pathFindService;

    public SubwayController(PathFindService pathFindService) {
        this.pathFindService = pathFindService;
    }

    public void run() {
        ControllerCommand controllerCommand = readCommand();
        while (controllerCommand.isNotQuit()) {
            try {
                search();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
            controllerCommand = readCommand();
        }
    }

    private ControllerCommand readCommand() {
        CommandDto commandDto = Retry.execute(inputView::readCommand);
        return ControllerCommand.from(commandDto.getCommand());
    }

    private void search() {
        CommandDto commandDto = Retry.execute(inputView::readLogicCommand);
        LogicCommand command = LogicCommand.from(commandDto.getCommand());
        if (command.isBack()) {
            return;
        }
        pathFind(command);
    }

    private void pathFind(LogicCommand command) {
        PathDto pathDto = Retry.execute(inputView::readPath);
        ResultDto resultDto = pathFindService.find(pathDto, command);
        outputView.printResult(resultDto);
    }
}
