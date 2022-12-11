package subway.dto;

public class CommandDto {

    private final String command;

    public CommandDto(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
