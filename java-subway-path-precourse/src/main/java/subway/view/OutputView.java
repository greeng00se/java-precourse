package subway.view;

import static java.text.MessageFormat.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import subway.dto.ResultDto;

public class OutputView {

    private static final String EXCEPTION_MESSAGE = "[ERROR] ";
    private static final String RESULT_MESSAGE_FORMAT = "[INFO] ---\n"
            + "[INFO] 총 거리: {0}km\n"
            + "[INFO] 총 소요 시간: {1}분\n"
            + "[INFO] ---\n"
            + "{2}\n";
    private static final String STATION_MESSAGE_FORMAT = "[INFO] {0}";
    private static final String STATION_DELIMITER = "\n";

    public void printResult(ResultDto resultDto) {
        String station = generateStationMessage(resultDto.getStation());
        System.out.println(format(RESULT_MESSAGE_FORMAT, resultDto.getDistance(), resultDto.getTime(), station));
    }

    private String generateStationMessage(List<String> station) {
        return station.stream()
                .map(name -> format(STATION_MESSAGE_FORMAT, name))
                .collect(Collectors.joining(STATION_DELIMITER));
    }

    public void printException(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
