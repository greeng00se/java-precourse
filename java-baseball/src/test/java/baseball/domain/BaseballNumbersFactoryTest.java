package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballNumbersFactory")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumbersFactoryTest {

    private final BaseballNumbersFactory sut = new BaseballNumbersFactory();

    @Test
    void generateBaseballNumbers_메서드는_입력값이_없으면_무작위로_생성된_BaseballNumbers를_반환한다() {
        assertThat(sut.generateBaseballNumbers()).isInstanceOf(BaseballNumbers.class);
    }

    @Test
    void generateBaseballNumbers_메서드는_1부터_9사이의_중복되지_않은_3자리_문자를_입력받아_BaseballNumbers를_반환한다() {
        assertThat(sut.generateBaseballNumbers("614")).isInstanceOf(BaseballNumbers.class);
    }
}
