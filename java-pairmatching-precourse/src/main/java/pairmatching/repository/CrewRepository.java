package pairmatching.repository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {

    private static final List<Crew> repository = new ArrayList<>();

    public void saveAll(List<Crew> crews) {
        repository.addAll(crews);
    }

    public List<String> findAllNameByCourse(Course course) {
        return repository.stream()
                .filter(crew -> crew.isSameCourse(course))
                .map(Crew::getName)
                .collect(toList());
    }

    public void clear() {
        repository.clear();
    }
}
