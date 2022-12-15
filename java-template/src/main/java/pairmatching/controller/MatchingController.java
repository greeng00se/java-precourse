package pairmatching.controller;

import pairmatching.dto.InformationDto;
import pairmatching.service.MatchingService;
import pairmatching.util.Retry;

public class MatchingController extends AbstractController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    protected void process() {
        InformationDto informationDto = new InformationDto();
        Retry.execute(matchingService::match, informationDto);
    }
}
