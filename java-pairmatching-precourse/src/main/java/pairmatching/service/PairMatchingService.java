package pairmatching.service;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatchingMachine;
import pairmatching.dto.InformationDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchingService {

    private static final String PAIR_MATCHING_FAIL_MESSAGE = "페어 매칭에 실패하였습니다.";
    private static final String INVALID_MATCHING_INFO_MESSAGE = "매칭 이력이 없습니다.";

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

    public PairMatchingDto pairMatching(InformationDto informationDto) {
        Level level = Level.from(informationDto.getLevel());
        Mission mission = missionRepository.findByLevelAndName(level, informationDto.getMission());
        Course course = Course.from(informationDto.getCourse());
        List<Pair> pairs = PairMatchingMachine.generatePair(crewRepository.findByCourse(course), course, level);
        validatePairs(pairs, level);
        pairMatchingRepository.saveAll(pairs, mission);
        return new PairMatchingDto(pairs);
    }

    private void validatePairs(List<Pair> pairs, Level level) {
        for (Pair pair : pairs) {
            if (pairMatchingRepository.isPairInSameLevel(pair.getPairs(), level)) {
                throw new IllegalStateException(PAIR_MATCHING_FAIL_MESSAGE);
            }
        }
    }

    public void removePairMatching(InformationDto informationDto) {
        Level level = Level.from(informationDto.getLevel());
        Mission mission = missionRepository.findByLevelAndName(level, informationDto.getMission());
        Course course = Course.from(informationDto.getCourse());
        pairMatchingRepository.remove(course, mission);
    }

    public void resetPairMatching() {
        pairMatchingRepository.clear();
    }

    public boolean hasPairMatchingInformation(InformationDto informationDto) {
        Level level = Level.from(informationDto.getLevel());
        Mission mission = missionRepository.findByLevelAndName(level, informationDto.getMission());
        Course course = Course.from(informationDto.getCourse());

        return pairMatchingRepository.hasPairMatchingInformation(course, mission);
    }

    public PairMatchingDto searchPairMatching(InformationDto informationDto) {
        Level level = Level.from(informationDto.getLevel());
        Mission mission = missionRepository.findByLevelAndName(level, informationDto.getMission());
        Course course = Course.from(informationDto.getCourse());

        if (!pairMatchingRepository.hasPairMatchingInformation(course, mission)) {
            throw new IllegalArgumentException(INVALID_MATCHING_INFO_MESSAGE);
        }
        return new PairMatchingDto(pairMatchingRepository.findByCourseAndMission(course, mission));
    }
}
