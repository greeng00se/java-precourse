package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EdgeRepository {

    private static final Map<Stations, Edge> repository = new HashMap<>();

    public Map<Stations, Edge> edges() {
        return Collections.unmodifiableMap(repository);
    }

    public void addEdge(Stations stations, Edge edge) {
        repository.put(stations, edge);
    }

    public void deleteByStations(Stations stations) {
        repository.remove(stations);
    }

    public void deleteAll() {
        repository.clear();
    }
}
