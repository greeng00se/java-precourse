package pairmatching.service;

import pairmatching.domain.Mission;
import pairmatching.domain.PairMatchingInformation;
import pairmatching.domain.Pairs;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchingQueryService {

    private static final String INVALID_MATCHING_INFO_MESSAGE = "매칭 이력이 없습니다.";

    private final MissionRepository missionRepository;
    private final PairMatchingRepository pairMatchingRepository;

    public PairMatchingQueryService(MissionRepository missionRepository,
                                    PairMatchingRepository pairMatchingRepository) {
        this.missionRepository = missionRepository;
        this.pairMatchingRepository = pairMatchingRepository;
    }

    public boolean hasPairMatchingInformation(InformationDto information) {
        PairMatchingInformation pairMatchingInformation = generatePairMatchingInformation(information);
        return pairMatchingRepository.existsByInformation(pairMatchingInformation);
    }

    public PairMatchingDto searchPairMatching(InformationDto information) {
        PairMatchingInformation pairMatchingInformation = generatePairMatchingInformation(information);
        if (!pairMatchingRepository.existsByInformation(pairMatchingInformation)) {
            throw new IllegalArgumentException(INVALID_MATCHING_INFO_MESSAGE);
        }

        Pairs pairs = pairMatchingRepository.findByInformation(pairMatchingInformation);
        return new PairMatchingDto(pairs.getPairs());
    }

    private PairMatchingInformation generatePairMatchingInformation(InformationDto information) {
        Mission mission = missionRepository.findByLevelAndName(information.getLevel(), information.getMissionName());
        return new PairMatchingInformation(information.getCourse(), mission);
    }
}
