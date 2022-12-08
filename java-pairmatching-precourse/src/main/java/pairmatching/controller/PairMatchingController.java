package pairmatching.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import pairmatching.dto.CommandDto;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.dto.RematchCommandDto;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private static final int REPEAT_COUNT = 3;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PairMatchingService pairMatchingService;
    private final Map<ControllerCommand, Runnable> service = new HashMap<>();

    public PairMatchingController(PairMatchingService pairMatchingService) {
        this.pairMatchingService = pairMatchingService;
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
        CommandDto commandDto = repeat(inputView::readCommand);
        return ControllerCommand.from(commandDto.getCommand());
    }

    private void matching() {
        InformationDto informationDto = repeat(inputView::readInformation);
        boolean matchingInformation = pairMatchingService.hasPairMatchingInformation(informationDto);
        if (matchingInformation) {
            doRematch(informationDto);
            return;
        }
        PairMatchingDto pairMatchingDto = repeatThreeTimes(pairMatchingService::pairMatching, informationDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void doRematch(InformationDto informationDto) {
        RematchCommandDto rematchCommandDto = repeat(inputView::readRematchCommand);
        if (rematchCommandDto.getRematchCommand()) {
            pairMatchingService.removePairMatching(informationDto);
            PairMatchingDto pairMatchingDto = repeatThreeTimes(pairMatchingService::pairMatching, informationDto);
            outputView.printPairMatchingResult(pairMatchingDto);
        }
    }

    private void search() {
        InformationDto informationDto = repeat(inputView::readInformation);
        PairMatchingDto pairMatchingDto = pairMatchingService.searchPairMatching(informationDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void reset() {
        pairMatchingService.resetPairMatching();
        outputView.printReset();
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return repeat(inputReader);
        }
    }

    private <T, R> R repeatThreeTimes(Function<T, R> service, T t) {
        for (int i = 0; i < REPEAT_COUNT; i++) {
            try {
                return service.apply(t);
            } catch (IllegalStateException e) {
                outputView.printException(e.getMessage());
            }
        }
        throw new IllegalArgumentException();
    }
}
