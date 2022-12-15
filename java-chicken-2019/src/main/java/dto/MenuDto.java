package dto;

import domain.Menu;
import java.util.List;

public class MenuDto {

    private final List<Menu> menus;

    public MenuDto(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
