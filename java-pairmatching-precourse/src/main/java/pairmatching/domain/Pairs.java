package pairmatching.domain;

import java.util.List;

public class Pairs {

    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public boolean isAlreadyPairing(Pair other) {
        return pairs.stream()
                .anyMatch(pair -> pair.isAlreadyPairing(other));
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
