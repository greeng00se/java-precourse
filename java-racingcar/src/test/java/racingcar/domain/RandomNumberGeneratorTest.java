package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumberGenerator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberGeneratorTest {

    @Test
    void generate_메서드는_0부터_9사이의_값을_반환한다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        Assertions.assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}
