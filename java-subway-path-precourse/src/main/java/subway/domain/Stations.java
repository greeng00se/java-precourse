package subway.domain;

import java.util.Objects;

public class Stations {

    private final Station start;
    private final Station end;

    public Stations(Station start, Station end) {
        this.start = start;
        this.end = end;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stations stations = (Stations) o;
        return Objects.equals(start, stations.start) && Objects.equals(end, stations.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
