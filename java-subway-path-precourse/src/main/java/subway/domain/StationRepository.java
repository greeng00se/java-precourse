package subway.domain;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final String INVALID_STATION_MESSAGE = "{0}역은 존재하지 않습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public void deleteAll() {
        stations.clear();
    }

    public Station findByName(String name) {
        return stations().stream()
                .filter(station -> station.equals(new Station(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format(INVALID_STATION_MESSAGE, name)));
    }
}
