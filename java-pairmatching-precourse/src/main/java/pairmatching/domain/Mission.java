package pairmatching.domain;

import java.util.Objects;

public class Mission {

    private final Level level;
    private final String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public boolean isSameLevel(Level level) {
        return this.level == level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission = (Mission) o;
        return level == mission.level && Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, name);
    }
}
