package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void valueOf_메서드는_1부터_45사이의_로또번호가_아닌_값을_입력받으면_IllegalArgumentException을_던진다(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 45 사이의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void valueOf_메서드는_1부터_45사이의_값을_입력받으면_LottoNumber_인스턴스를_반환한다(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @Test
    void getNumber_메서드는_로또번호를_반환한다() {
        LottoNumber lottoNumber = LottoNumber.valueOf(45);

        assertThat(lottoNumber.getNumber()).isEqualTo(45);
    }
}
