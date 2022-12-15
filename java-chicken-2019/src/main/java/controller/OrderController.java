package controller;

import domain.Menu;
import dto.TableDto;
import java.util.List;
import service.OrderService;
import service.SearchService;
import view.InputView;
import view.OutputView;

public class OrderController extends AbstractController {

    private final InputView inputView = InputView.INSTANCE;
    private final OutputView outputView = OutputView.INSTANCE;

    private final SearchService searchService;
    private final OrderService orderService;

    public OrderController(SearchService searchService, OrderService orderService) {
        this.searchService = searchService;
        this.orderService = orderService;
    }

    @Override
    protected void process() {
        Integer table = readTable();
        Integer menu = readMenu();
        Integer quantity = inputView.readQuantity();
        orderService.order(table, menu, quantity);
    }

    private Integer readTable() {
        TableDto tableDto = searchService.searchTables();
        outputView.printTables(tableDto);
        return inputView.readTable();
    }

    private Integer readMenu() {
        List<Menu> menus = searchService.searchMenus();
        outputView.printMenus(menus);
        return inputView.readMenu();
    }
}
