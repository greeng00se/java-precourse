package subway.dto;

public class PathDto {

    private final String start;
    private final String end;

    public PathDto(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
