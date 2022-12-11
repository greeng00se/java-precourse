package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Pair {

    private static final int MINIMUM_PARING_COUNT = 2;

    private final List<Crew> crews;

    public Pair(List<Crew> pair) {
        this.crews = pair;
    }

    public boolean isAlreadyPairing(Pair other) {
        return MINIMUM_PARING_COUNT <= other.crews.stream()
                .filter(this.crews::contains)
                .count();
    }

    public List<String> getCrewName() {
        return crews.stream()
                .map(Crew::getName)
                .collect(toList());
    }
}
