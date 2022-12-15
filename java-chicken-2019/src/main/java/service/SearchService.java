package service;

import domain.Table;
import dto.TableDto;
import java.util.List;
import java.util.stream.Collectors;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.TableRepository;

public class SearchService {

    private final MenuRepository menuRepository;
    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;

    public SearchService(MenuRepository menuRepository, TableRepository tableRepository,
                         OrderRepository orderRepository) {
        this.menuRepository = menuRepository;
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
    }

    public TableDto searchTables() {
        List<Table> tables = tableRepository.findAll();
        List<Boolean> orderExists = orderRepository.existsByTables(tables);
        List<Integer> tableNumbers = tables.stream()
                .map(Table::getNumber)
                .collect(Collectors.toList());
        return new TableDto(tableNumbers, orderExists);
    }
}
