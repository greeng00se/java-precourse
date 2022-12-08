package pairmatching.repository;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class PairMatchingRepository {

    private final Map<Pair, Mission> pairToMission = new HashMap<>();

    public boolean hasPairMatchingInformation(Course course, Mission mission) {
        return pairToMission.keySet().stream()
                .filter(pair -> pairToMission.get(pair).equals(mission))
                .anyMatch(pair -> pair.isSameCourse(course));
    }

    public void saveAll(List<Pair> pairs, Mission mission) {
        for (Pair pair : pairs) {
            pairToMission.put(pair, mission);
        }
    }

    public boolean isPairInSameLevel(List<Crew> crews, Level level) {
        return pairToMission.keySet().stream()
                .filter(pair -> pairToMission.get(pair).isSameLevel(level))
                .anyMatch(pair -> pair.isAlreadyPair(crews));
    }

    public void clear() {
        pairToMission.clear();
    }

    public void remove(Course course, Mission mission) {
        List<Pair> pairs = pairToMission.keySet().stream()
                .filter(pair -> pairToMission.get(pair).equals(mission))
                .filter(pair -> pair.isSameCourse(course))
                .collect(toList());
        pairs.forEach(pairToMission.keySet()::remove);
    }

    public List<Pair> findByCourseAndMission(Course course, Mission mission) {
        return pairToMission.keySet().stream()
                .filter(pair -> pairToMission.get(pair).equals(mission))
                .filter(pair -> pair.isSameCourse(course))
                .collect(toList());
    }
}
