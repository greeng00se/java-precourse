package racingcar.dto;

public class PlayCountDto {

    private final String playCount;

    public PlayCountDto(String playCount) {
        this.playCount = playCount;
    }

    public Integer getPlayCount() {
        return Integer.valueOf(playCount);
    }
}
