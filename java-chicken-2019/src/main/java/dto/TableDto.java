package dto;

import java.util.List;

public class TableDto {

    private final List<Integer> tableNumber;
    private final List<Boolean> orderExists;

    public TableDto(List<Integer> tableNumber, List<Boolean> orderExists) {
        this.tableNumber = tableNumber;
        this.orderExists = orderExists;
    }

    public List<Integer> getTableNumber() {
        return tableNumber;
    }

    public List<Boolean> getOrderExists() {
        return orderExists;
    }

    public Integer getTableSize() {
        return tableNumber.size();
    }
}
