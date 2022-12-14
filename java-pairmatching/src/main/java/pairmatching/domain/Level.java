package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String INVALID_LEVEL_MESSAGE = "올바르지 않은 레벨명입니다.";

    private String name;

    Level(String name) {
        this.name = name;
    }
    
    public static Level from(String name) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LEVEL_MESSAGE));
    }
}
