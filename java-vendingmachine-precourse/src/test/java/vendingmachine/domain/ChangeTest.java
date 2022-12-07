package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Change 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ChangeTest {

    @Test
    void 생성자는_올바르지_않은_거스름돈_형식을_입력하면_IllegalArgumentException을_던진다() {
        Assertions.assertThatThrownBy(() -> new Change(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("거스름돈은 10원 단위로 입력해야합니다.");
    }

    @Test
    void calculateSum_메서드는_현재_남아있는_동전의_총합을_반환한다() {
        Change change = new Change(1500);

        assertThat(change.calculateSum()).isEqualTo(1500);
    }
}
