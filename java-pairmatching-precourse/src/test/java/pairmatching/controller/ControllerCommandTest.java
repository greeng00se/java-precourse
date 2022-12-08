package pairmatching.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("ControllerCommand")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ControllerCommandTest {

    @Test
    void from_메서드는_command를_입력받아_인스턴스를_반환한다() {
        ControllerCommand command = ControllerCommand.from("1");

        assertThat(command).isEqualTo(ControllerCommand.MATCHING);
    }

    @Test
    void isQuit_메서드는_인스턴스가_QUIT인_경우_true를_반환한다() {
        assertThat(ControllerCommand.QUIT.isQuit()).isTrue();
    }
}
