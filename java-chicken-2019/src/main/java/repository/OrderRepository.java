package repository;

import domain.Orders;
import domain.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepository {

    private final Map<Table, Orders> orders = new HashMap<>();

    public List<Boolean> existsByTables(List<Table> tables) {
        return tables.stream()
                .map(orders::containsKey)
                .collect(Collectors.toList());
    }
}
