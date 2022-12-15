package pairmatching.service;

import pairmatching.dto.InformationDto;
import pairmatching.repository.CrewRepository;

public class MatchingService {

    private final CrewRepository crewRepository;

    public MatchingService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public InformationDto match(InformationDto information) {
        return new InformationDto();
    }
}
