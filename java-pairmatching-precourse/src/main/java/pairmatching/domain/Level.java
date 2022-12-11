package pairmatching.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String INVALID_LEVEL_NAME_MESSAGE = "올바른 레벨명이 아닙니다.";

    private String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static List<String> names() {
        return Arrays.stream(values())
                .map(level -> level.name)
                .collect(toList());
    }

    public static Level from(String name) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LEVEL_NAME_MESSAGE));
    }
}
