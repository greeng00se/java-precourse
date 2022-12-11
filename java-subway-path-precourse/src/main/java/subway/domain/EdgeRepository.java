package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

    public List<Stations> findAllStations() {
        return new ArrayList<>(repository.keySet());
    }

    public Integer findTimeByStations(Stations stations) {
        Edge edge = repository.get(stations);
        return edge.getTime();
    }

    public Integer findDistanceByStations(Stations stations) {
        Edge edge = repository.get(stations);
        return edge.getDistance();
    }
}
