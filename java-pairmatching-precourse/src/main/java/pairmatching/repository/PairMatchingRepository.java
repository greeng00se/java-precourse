package pairmatching.repository;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.Level;
import pairmatching.domain.PairMatchingInformation;
import pairmatching.domain.Pairs;

public class PairMatchingRepository {

    private static final Map<PairMatchingInformation, Pairs> repository = new HashMap<>();

    public boolean existsByInformation(PairMatchingInformation information) {
        return repository.containsKey(information);
    }

    public void save(PairMatchingInformation pairMatchingInformation, Pairs pairs) {
        repository.put(pairMatchingInformation, pairs);
    }

    public Pairs findByInformation(PairMatchingInformation information) {
        return repository.get(information);
    }

    public Pairs findAllPairsByLevel(Level level) {
        return repository.keySet().stream()
                .filter(information -> information.isSameLevel(level))
                .map(information -> repository.get(information).getPairs())
                .flatMap(Collection::stream)
                .collect(collectingAndThen(toList(), Pairs::new));
    }

    public void remove(PairMatchingInformation information) {
        repository.remove(information);
    }

    public void clear() {
        repository.clear();
    }
}
