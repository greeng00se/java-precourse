package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String INVALID_COURSE_NAME_MESSAGE = "올바른 코스명이 아닙니다.";

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static List<String> names() {
        return Arrays.stream(values())
                .map(course -> course.name)
                .collect(toList());
    }

    public static Course from(String name) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_NAME_MESSAGE));
    }
}
