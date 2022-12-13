package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InformationDto {

    private final Course course;
    private final Level level;
    private final String string;

    public InformationDto(Course course, Level level, String string) {
        this.course = course;
        this.level = level;
        this.string = string;
    }
}
