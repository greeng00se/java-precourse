package pairmatching.controller;

import static pairmatching.controller.Retry.execute;

import pairmatching.controller.command.RematchCommand;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.service.PairMatchingCommandService;
import pairmatching.service.PairMatchingQueryService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController implements Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PairMatchingQueryService pairMatchingQueryService;
    private final PairMatchingCommandService pairMatchingCommandService;

    public MatchingController(PairMatchingQueryService pairMatchingQueryService,
                              PairMatchingCommandService pairMatchingCommandService) {
        this.pairMatchingQueryService = pairMatchingQueryService;
        this.pairMatchingCommandService = pairMatchingCommandService;
    }

    @Override
    public void run() {
        InformationDto informationDto = execute(inputView::readInformation);
        if (pairMatchingQueryService.hasPairMatchingInformation(informationDto)) {
            rematch(informationDto);
            return;
        }
        PairMatchingDto pairMatchingDto = execute(pairMatchingCommandService::pairMatching, informationDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void rematch(InformationDto informationDto) {
        RematchCommand rematchCommand = execute(inputView::readRematchCommand);
        if (rematchCommand.isRematch()) {
            pairMatchingCommandService.removePairMatching(informationDto);
            PairMatchingDto pairMatchingDto = execute(pairMatchingCommandService::pairMatching, informationDto);
            outputView.printPairMatchingResult(pairMatchingDto);
        }
    }
}
