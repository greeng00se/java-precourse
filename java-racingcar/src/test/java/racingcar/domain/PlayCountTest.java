package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("PlayCount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayCountTest {

    @Test
    void play_메서드는_playCount를_하나_감소시킨다() {
        PlayCount sut = new PlayCount(1);

        sut.play();

        assertThat(sut.isPlayable()).isFalse();
    }

    @Test
    void isPlayable_메서드는_playCount가_0인경우_false를_반환한다() {
        PlayCount sut = new PlayCount(0);

        assertThat(sut.isPlayable()).isFalse();
    }

    @Test
    void isPlayable_메서드는_playCount가_1이상인_경우_true를_반환한다() {
        PlayCount sut = new PlayCount(1);

        assertThat(sut.isPlayable()).isTrue();
    }
}
