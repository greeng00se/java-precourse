package dto;

public class OrderDto {
    private final String table;
    private final String menu;
    private final String quantity;

    public OrderDto(String table, String menu, String quantity) {
        this.table = table;
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getTable() {
        return table;
    }

    public String getMenu() {
        return menu;
    }

    public String getQuantity() {
        return quantity;
    }
}
