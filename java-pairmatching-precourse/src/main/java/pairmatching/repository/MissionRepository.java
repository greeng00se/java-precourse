package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Mission;

public class MissionRepository {

    private final List<Mission> missions = new ArrayList<>();

    public void saveAll(List<Mission> missions) {
        this.missions.addAll(missions);
    }
}
