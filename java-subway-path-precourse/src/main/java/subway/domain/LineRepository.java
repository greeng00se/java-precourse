package subway.domain;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String INVALID_LINE_MESSAGE = "{0}은 존재하지 않습니다.";

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public void deleteAll() {
        lines.clear();
    }

    public Line findByName(String name) {
        return lines().stream()
                .filter(line -> line.equals(new Line(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format(INVALID_LINE_MESSAGE, name)));
    }
}
