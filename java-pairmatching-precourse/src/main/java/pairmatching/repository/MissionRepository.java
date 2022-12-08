package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {

    private static final String INVALID_MISSION_MESSAGE = "미션이 존재하지 않습니다.";

    private final List<Mission> missions = new ArrayList<>();

    public void saveAll(List<Mission> missions) {
        this.missions.addAll(missions);
    }

    public Mission findByLevelAndName(Level level, String missionName) {
        return missions.stream()
                .filter(mission -> mission.equals(new Mission(level, missionName)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_MESSAGE));
    }
}
