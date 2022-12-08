package pairmatching.controller;

import pairmatching.dto.CommandDto;
import pairmatching.dto.InformationDto;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PairMatchingService pairMatchingService;

    public PairMatchingController(PairMatchingService pairMatchingService) {
        this.pairMatchingService = pairMatchingService;
    }

    public void run() {

        while (true) {
            ControllerCommand controllerCommand = readCommand();
            if (controllerCommand.isQuit()) {
                break;
            }

            if (controllerCommand == ControllerCommand.MATCHING) {
                InformationDto informationDto = inputView.readInformation();
            }
        }
    }

    private ControllerCommand readCommand() {
        CommandDto commandDto = inputView.readCommand();
        return ControllerCommand.from(commandDto.getCommand());
    }
}
