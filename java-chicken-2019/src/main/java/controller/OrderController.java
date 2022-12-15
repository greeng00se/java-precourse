package controller;

import dto.TableDto;
import service.SearchService;
import view.InputView;
import view.OutputView;

public class OrderController extends AbstractController {

    private final InputView inputView = InputView.INSTANCE;
    private final OutputView outputView = OutputView.INSTANCE;

    private final SearchService searchService;

    public OrderController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    protected void process() {
        TableDto tables = searchService.searchTables();
        outputView.printTables(tables);
    }
}
