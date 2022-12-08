package pairmatching.service;

import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchingService {

    private final CrewRepository crewRepository;
    private final MissionRepository missionRepository;
    private final PairMatchingRepository pairMatchingRepository;

    public PairMatchingService(
            CrewRepository crewRepository,
            MissionRepository missionRepository,
            PairMatchingRepository pairMatchingRepository
    ) {
        this.crewRepository = crewRepository;
        this.missionRepository = missionRepository;
        this.pairMatchingRepository = pairMatchingRepository;
    }
}
