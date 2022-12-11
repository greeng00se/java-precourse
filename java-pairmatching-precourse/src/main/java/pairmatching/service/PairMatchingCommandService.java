package pairmatching.service;

import java.util.List;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatchingInformation;
import pairmatching.domain.PairMatchingMachine;
import pairmatching.domain.Pairs;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchingCommandService {

    private final CrewRepository crewRepository;
    private final MissionRepository missionRepository;
    private final PairMatchingRepository pairMatchingRepository;

    public PairMatchingCommandService(
            CrewRepository crewRepository,
            MissionRepository missionRepository,
            PairMatchingRepository pairMatchingRepository
    ) {
        this.crewRepository = crewRepository;
        this.missionRepository = missionRepository;
        this.pairMatchingRepository = pairMatchingRepository;
    }

    public PairMatchingDto pairMatching(InformationDto information) {
        PairMatchingInformation pairMatchingInformation = generatePairMatchingInformation(information);
        List<String> crewNames = crewRepository.findAllNameByCourse(information.getCourse());
        Pairs pairsByLevel = pairMatchingRepository.findAllPairsByLevel(information.getLevel());
        List<Pair> pairs = PairMatchingMachine.generate(crewNames, information.getCourse(), pairsByLevel);
        pairMatchingRepository.save(pairMatchingInformation, new Pairs(pairs));
        return new PairMatchingDto(pairs);
    }

    public void removePairMatching(InformationDto information) {
        PairMatchingInformation pairMatchingInformation = generatePairMatchingInformation(information);
        pairMatchingRepository.remove(pairMatchingInformation);
    }

    public void resetPairMatching() {
        pairMatchingRepository.clear();
    }

    private PairMatchingInformation generatePairMatchingInformation(InformationDto information) {
        Mission mission = missionRepository.findByLevelAndName(information.getLevel(), information.getMissionName());
        return new PairMatchingInformation(information.getCourse(), mission);
    }
}
