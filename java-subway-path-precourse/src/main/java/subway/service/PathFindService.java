package subway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.controller.LogicCommand;
import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Stations;
import subway.dto.PathDto;
import subway.dto.ResultDto;

public class PathFindService {

    private static final String INVALID_PATH_MESSAGE = "출발역과 도착역이 동일합니다.";

    private final EdgeRepository edgeRepository;
    private final StationRepository stationRepository;
    private final Map<LogicCommand, Function<Stations, Integer>> service = new HashMap<>();

    public PathFindService(EdgeRepository edgeRepository, StationRepository stationRepository) {
        this.edgeRepository = edgeRepository;
        this.stationRepository = stationRepository;
        service.put(LogicCommand.TIME, edgeRepository::findTimeByStations);
        service.put(LogicCommand.DISTANCE, edgeRepository::findDistanceByStations);
    }

    public ResultDto find(PathDto pathDto, LogicCommand command) {
        DijkstraShortestPath dijkstraShortestPath = generateGraph(command);
        List<Station> result = findPath(pathDto, dijkstraShortestPath);
        Integer time = calculate(result, edgeRepository::findTimeByStations);
        Integer distance = calculate(result, edgeRepository::findDistanceByStations);
        return new ResultDto(distance, time, result.stream()
                .map(Station::getName)
                .collect(Collectors.toList())
        );
    }

    private Integer calculate(List<Station> path, Function<Stations, Integer> findValue) {
        Integer result = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            result += findValue.apply(new Stations(path.get(i), path.get(i + 1)));
        }
        return result;
    }

    private DijkstraShortestPath generateGraph(LogicCommand command) {
        Graph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        List<Stations> stations = edgeRepository.findAllStations();
        for (Stations station : stations) {
            setEdgeWeight(graph, station, command);
        }
        return new DijkstraShortestPath(graph);
    }

    private void setEdgeWeight(Graph<Station, DefaultWeightedEdge> graph, Stations station, LogicCommand command) {
        graph.addVertex(station.getStart());
        graph.addVertex(station.getEnd());
        Integer weight = service.get(command).apply(station);
        graph.setEdgeWeight(graph.addEdge(station.getStart(), station.getEnd()), weight);
    }

    private List<Station> findPath(PathDto pathDto, DijkstraShortestPath dijkstraShortestPath) {
        Station start = stationRepository.findByName(pathDto.getStart());
        Station end = stationRepository.findByName(pathDto.getEnd());
        if (start.equals(end)) {
            throw new IllegalArgumentException(INVALID_PATH_MESSAGE);
        }
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }
}
