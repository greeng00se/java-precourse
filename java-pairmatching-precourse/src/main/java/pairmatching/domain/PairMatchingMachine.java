package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatchingMachine {

    private static final int MINIMUM_PAIR_SIZE = 3;
    private static final int REMOVE_INDEX = 0;

    public static List<Pair> generatePair(List<String> crewNames, Course course, Level level) {
        List<Crew> crews = shuffle(crewNames, course);
        List<Pair> result = new ArrayList<>();

        while (crews.size() > MINIMUM_PAIR_SIZE) {
            Crew crew1 = crews.remove(REMOVE_INDEX);
            Crew crew2 = crews.remove(REMOVE_INDEX);
            result.add(new Pair(List.of(crew1, crew2), level));
        }
        result.add(new Pair(crews, level));

        return result;
    }

    private static List<Crew> shuffle(List<String> crewNames, Course course) {
        List<String> crewList = Randoms.shuffle(crewNames);
        return crewList.stream()
                .map(name -> new Crew(course, name))
                .collect(toList());
    }
}
