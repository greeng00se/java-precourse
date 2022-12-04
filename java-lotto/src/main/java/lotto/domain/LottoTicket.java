package lotto.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Lotto> ticket;

    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    public LottoResult check(Lotto winningNumber, LottoNumber bonusNumber) {
        return ticket.stream()
                .map(lotto -> lotto.check(winningNumber, bonusNumber))
                .collect(collectingAndThen(groupingBy(identity(), counting()), LottoResult::new));
    }

    public List<List<Integer>> getTicket() {
        return ticket.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
