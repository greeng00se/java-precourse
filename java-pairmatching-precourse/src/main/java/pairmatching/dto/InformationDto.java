package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InformationDto {

    private final Course course;
    private final Level level;
    private final String missionName;

    public InformationDto(String course, String level, String missionName) {
        this.course = Course.from(course);
        this.level = Level.from(level);
        this.missionName = missionName;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMissionName() {
        return missionName;
    }
}
