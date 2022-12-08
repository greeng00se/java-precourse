package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Level Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {

    @Test
    void names_메서드는_Level명을_반환한다() {
        List<String> levelNames = Level.names();

        assertThat(levelNames).containsExactly("레벨1", "레벨2", "레벨3", "레벨4", "레벨5");
    }

    @Test
    void from_메서드는_올바른_Level명을_입력받지_못하면_IllegalArgumentException을_던진다() {
        Assertions.assertThatThrownBy(() -> Level.from("레벨6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from_메서드는_올바른_Level명을_입력받으면_인스턴스를_반환한다() {
        Level level = Level.from("레벨5");

        assertThat(level).isEqualTo(Level.LEVEL5);
    }
}
