package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {

    private static final String INVALID_MISSION_MESSAGE = "미션이 존재하지 않습니다.";
    private static final List<Mission> repository = new ArrayList<>();

    public void saveAll(List<Mission> missions) {
        repository.addAll(missions);
    }

    public Mission findByLevelAndName(Level level, String name) {
        return repository.stream()
                .filter(mission -> mission.equals(new Mission(level, name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_MESSAGE));
    }

    public List<Mission> findAll() {
        return new ArrayList<>(repository);
    }

    public void clear() {
        repository.clear();
    }
}
