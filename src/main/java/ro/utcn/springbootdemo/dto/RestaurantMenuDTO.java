package ro.utcn.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.utcn.springbootdemo.entities.Restaurant;

@Data
@AllArgsConstructor
public class RestaurantMenuDTO {
    private Restaurant restaurant;
    private String menuName;
    private int menuPrice;


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public RestaurantMenuDTO(Restaurant restaurant, String menuName, int menuPrice) {
        this.restaurant = restaurant;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }
}
