package subway.domain;

import java.util.Objects;

public class Edge {

    private final Integer distance;
    private final Integer time;

    public Edge(Integer distance, Integer time) {
        this.distance = distance;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return Objects.equals(distance, edge.distance) && Objects.equals(time, edge.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, time);
    }
}
