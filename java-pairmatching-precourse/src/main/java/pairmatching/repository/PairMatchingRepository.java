package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.Mission;
import pairmatching.domain.Pairs;

public class PairMatchingRepository {

    private final Map<Mission, Pairs> missionToPairs = new HashMap<>();

}
