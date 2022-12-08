package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair {

    private static final int INVALID_CREW_COUNT = 2;

    private final List<Crew> pairs;
    private final Level level;

    public Pair(List<Crew> pairs, Level level) {
        this.pairs = pairs;
        this.level = level;
    }

    public boolean isSameCourse(Course course) {
        return pairs.stream()
                .findAny()
                .get()
                .isSameCourse(course);
    }

    public boolean isAlreadyPair(List<Crew> crews) {
        return crews.stream()
                .filter(pairs::contains)
                .count() >= INVALID_CREW_COUNT;
    }

    public List<String> getCrewName() {
        return pairs.stream()
                .map(Crew::getName)
                .collect(toList());
    }

    public List<Crew> getPairs() {
        return new ArrayList<>(pairs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(pairs, pair.pairs) && level == pair.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairs, level);
    }
}
