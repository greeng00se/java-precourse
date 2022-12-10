package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Pair {

    private static final int INVALID_CREW_COUNT = 2;

    private final List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public boolean isAlreadyPair(List<Crew> crews) {
        return crews.stream()
                .filter(pair::contains)
                .count() >= INVALID_CREW_COUNT;
    }

    public List<String> getCrewName() {
        return pair.stream()
                .map(Crew::getName)
                .collect(toList());
    }
}
