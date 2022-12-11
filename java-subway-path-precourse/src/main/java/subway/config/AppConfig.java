package subway.config;

import java.util.List;
import subway.domain.Edge;
import subway.domain.EdgeRepository;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Stations;

public class AppConfig {

    private static final String INFORMATION_DELIMITER = ",";
    private static final int START_STATION_INDEX = 0;
    private static final int END_STATION_INDEX = 1;
    private static final int DISTANCE_INDEX = 2;
    private static final int TIME_INDEX = 3;

    public static EdgeRepository edgeRepository() {
        EdgeRepository edgeRepository = new EdgeRepository();
        List<String> edgeInformation = List.of(
                "교대역,강남역,2,3",
                "강남역,역삼역,2,3",
                "교대역,남부터미널역,3,2",
                "남부터미널역,양재역,6,5",
                "양재역,매봉역,1,1",
                "강남역,양재역,2,8",
                "양재역,양재시민의숲역,10,3"
        );
        putInformation(edgeRepository, edgeInformation);
        return edgeRepository;
    }

    public static void putInformation(EdgeRepository edgeRepository, List<String> edgeInformation) {
        for (String information : edgeInformation) {
            String[] info = information.split(INFORMATION_DELIMITER);
            Station start = new Station(info[START_STATION_INDEX]);
            Station end = new Station(info[END_STATION_INDEX]);
            Integer distance = Integer.valueOf(info[DISTANCE_INDEX]);
            Integer time = Integer.valueOf(info[TIME_INDEX]);
            edgeRepository.addEdge(new Stations(start, end), new Edge(distance, time));
            edgeRepository.addEdge(new Stations(end, start), new Edge(distance, time));
        }
    }

    public static StationRepository stationRepository() {
        StationRepository stationRepository = new StationRepository();
        List<String> names = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역");
        for (String name : names) {
            stationRepository.addStation(new Station(name));
        }
        return stationRepository;
    }

    public static LineRepository lineRepository() {
        LineRepository lineRepository = new LineRepository();
        List<String> names = List.of("2호선", "3호선", "신분당선");
        for (String name : names) {
            lineRepository.addLine(new Line(name));
        }
        return lineRepository;
    }
}
