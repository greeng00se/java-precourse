package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String INVALID_COURSE_MESSAGE = "올바르지 않은 코스명입니다.";

    private String name;

    Course(String name) {
        this.name = name;
    }
    
    public static Course from(String name) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_MESSAGE));
    }
}
