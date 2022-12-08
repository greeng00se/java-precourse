package pairmatching.dto;

public class RematchCommandDto {

    private static final String NO = "아니오";

    private String rematch;

    public RematchCommandDto(String rematch) {
        this.rematch = rematch;
    }

    public boolean getRematchCommand() {
        if (rematch.equals(NO)) {
            return false;
        }
        return true;
    }
}
