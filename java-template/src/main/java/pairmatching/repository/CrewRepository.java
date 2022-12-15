package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {

    private static final List<String> repository = new ArrayList<>();

    public void saveAll(List<String> names) {
        repository.addAll(names);
        System.out.println(repository);
    }
}
