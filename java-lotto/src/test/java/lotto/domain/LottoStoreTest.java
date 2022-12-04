package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoStore 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoStoreTest {

    private final LottoStore sut = new LottoStore();

    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 0, 1594})
    void sell_메서드는_허용되지_않는_구매금액을_입력받으면_IllegalArgumentException을_던진다(int amount) {
        Assertions.assertThatThrownBy(() -> sut.sell(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 금액은 1,000원 단위어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "10000, 10"})
    void sell_메서드는_1000원_단위의_구매금액을_입력받으면_LottoTicket을_반환한다(int amount, int lottoTicketCount) {
        LottoTicket lottoTicket = sut.sell(amount);

        assertThat(lottoTicket.getTicket()).hasSize(lottoTicketCount);
    }
}
