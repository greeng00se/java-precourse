package baseball.dto;

public class GameStatusDto {

    private final String command;

    public GameStatusDto(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
