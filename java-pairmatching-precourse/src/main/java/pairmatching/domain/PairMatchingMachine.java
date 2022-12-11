package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatchingMachine {

    private static final int MINIMUM_PAIR_SIZE = 3;
    private static final int REMOVE_INDEX = 0;
    private static final String PAIR_MATCHING_FAIL_MESSAGE = "페어 매칭에 실패하였습니다.";

    public static List<Pair> generate(List<String> crewNames, Course course, Pairs pairsByLevel) {
        List<Crew> crews = shuffle(crewNames, course);
        List<Pair> result = generatePairs(crews);
        if (isAlreadyPairing(result, pairsByLevel)) {
            throw new IllegalArgumentException(PAIR_MATCHING_FAIL_MESSAGE);
        }
        return result;
    }

    private static List<Crew> shuffle(List<String> crewNames, Course course) {
        return Randoms.shuffle(crewNames).stream()
                .map(name -> new Crew(course, name))
                .collect(toList());
    }

    private static List<Pair> generatePairs(List<Crew> crews) {
        List<Pair> result = new ArrayList<>();
        while (crews.size() > MINIMUM_PAIR_SIZE) {
            Crew crew1 = crews.remove(REMOVE_INDEX);
            Crew crew2 = crews.remove(REMOVE_INDEX);
            result.add(new Pair(List.of(crew1, crew2)));
        }
        result.add(new Pair(crews));
        return result;
    }

    private static boolean isAlreadyPairing(List<Pair> result, Pairs pairsByLevel) {
        return result.stream()
                .anyMatch(pairsByLevel::isAlreadyPairing);
    }
}
