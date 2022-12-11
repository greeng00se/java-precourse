package subway.service;

import subway.dto.PathDto;
import subway.dto.ResultDto;

public interface PathFindService {

    ResultDto find(PathDto pathDto);
}
