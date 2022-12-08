package pairmatching.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {

    private static final File BACKEND = new File("src/main/resources/backend-crew.md");
    private static final File FRONTEND = new File("src/main/resources/frontend-crew.md");

    public static List<String> readBackend() throws IOException {
        return readCrewName(BACKEND);
    }

    public static List<String> readFrontend() throws IOException {
        return readCrewName(FRONTEND);
    }

    private static List<String> readCrewName(File file) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String crewName;
            while ((crewName = bufferedReader.readLine()) != null) {
                result.add(crewName);
            }
        }
        return result;
    }
}
