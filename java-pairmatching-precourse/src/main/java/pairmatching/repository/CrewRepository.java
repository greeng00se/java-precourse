package pairmatching.repository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {

    private final List<Crew> crews = new ArrayList<>();

    public void saveAll(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    public List<String> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(course))
                .map(Crew::getName)
                .collect(toList());
    }
}
