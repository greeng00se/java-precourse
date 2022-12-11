package pairmatching.domain;

import java.util.Objects;

public class PairMatchingInformation {

    private final Course course;
    private final Mission mission;

    public PairMatchingInformation(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public boolean isSameLevel(Level level) {
        return mission.isSameLevel(level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairMatchingInformation that = (PairMatchingInformation) o;
        return course == that.course && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
