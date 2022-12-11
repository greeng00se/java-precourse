package subway.dto;

import java.util.List;

public class ResultDto {

    private final Integer distance;
    private final Integer time;
    private final List<String> station;

    public ResultDto(Integer distance, Integer time, List<String> station) {
        this.distance = distance;
        this.time = time;
        this.station = station;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getTime() {
        return time;
    }

    public List<String> getStation() {
        return station;
    }
}
