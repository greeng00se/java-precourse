package pairmatching.dto;

import java.util.List;
import pairmatching.domain.Pair;

public class PairMatchingDto {

    private List<Pair> pairs;

    public PairMatchingDto(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
