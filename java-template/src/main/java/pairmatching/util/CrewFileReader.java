package pairmatching.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {

    private static final File BACKEND = new File("src/main/resources/backend-crew.md");
    private static final File FRONTEND = new File("src/main/resources/frontend-crew.md");
    private static final String INVALID_FILE_NAME = "올바른 파일명이 아닙니다.";

    public static List<String> readBackend() {
        return readName(BACKEND);
    }

    public static List<String> readFrontend() {
        return readName(FRONTEND);
    }

    private static List<String> readName(File file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String name;
            while ((name = bufferedReader.readLine()) != null) {
                result.add(name);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(INVALID_FILE_NAME);
        }
        return result;
    }
}
