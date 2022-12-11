package pairmatching.controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.dto.CommandDto;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.dto.RematchCommandDto;
import pairmatching.service.PairMatchingCommandService;
import pairmatching.service.PairMatchingQueryService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PairMatchingCommandService pairMatchingCommandService;
    private final PairMatchingQueryService pairMatchingQueryService;
    private final Map<ControllerCommand, Runnable> service = new HashMap<>();

    public PairMatchingController(PairMatchingCommandService pairMatchingCommandService,
                                  PairMatchingQueryService pairMatchingQueryService) {
        this.pairMatchingCommandService = pairMatchingCommandService;
        this.pairMatchingQueryService = pairMatchingQueryService;
        service.put(ControllerCommand.MATCHING, this::matching);
        service.put(ControllerCommand.SEARCH, this::search);
        service.put(ControllerCommand.RESET, this::reset);
    }

    public void run() {
        ControllerCommand controllerCommand = readCommand();
        while (controllerCommand.isNotQuit()) {
            try {
                service.get(controllerCommand).run();
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

    private void matching() {
        InformationDto informationDto = Retry.execute(inputView::readInformation);
        boolean matchingInformation = pairMatchingQueryService.hasPairMatchingInformation(informationDto);
        if (matchingInformation) {
            doRematch(informationDto);
            return;
        }
        PairMatchingDto pairMatchingDto = Retry.execute(pairMatchingCommandService::pairMatching, informationDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void doRematch(InformationDto informationDto) {
        RematchCommandDto rematchCommandDto = Retry.execute(inputView::readRematchCommand);
        if (rematchCommandDto.getRematchCommand()) {
            pairMatchingCommandService.removePairMatching(informationDto);
            PairMatchingDto pairMatchingDto = Retry.execute(pairMatchingCommandService::pairMatching, informationDto);
            outputView.printPairMatchingResult(pairMatchingDto);
        }
    }

    private void search() {
        InformationDto informationDto = Retry.execute(inputView::readInformation);
        PairMatchingDto pairMatchingDto = pairMatchingQueryService.searchPairMatching(informationDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void reset() {
        pairMatchingCommandService.resetPairMatching();
        outputView.printReset();
    }
}
