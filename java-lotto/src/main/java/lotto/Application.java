package lotto;

import lotto.controller.LottoController;
import lotto.domain.Customer;
import lotto.domain.LottoStore;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(getLottoService());
        lottoController.run();
    }

    private static LottoService getLottoService() {
        return new LottoService(lottoStore(), customer());
    }

    private static LottoStore lottoStore() {
        return new LottoStore();
    }

    private static Customer customer() {
        return new Customer();
    }
}
