package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {

    private static final String INVALID_MISSION_MESSAGE = "미션이 존재하지 않습니다.";
    private static final List<Mission> missions = new ArrayList<>();

    public static void saveAll(List<Mission> mission) {
        missions.addAll(mission);
    }

    public static Mission findByLevelAndName(Level level, String name) {
        return missions.stream()
                .filter(mission -> mission.equals(new Mission(level, name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_MESSAGE));
    }

    public static List<Mission> findAll() {
        return new ArrayList<>(missions);
    }

    public static void clear() {
        missions.clear();
    }
}
