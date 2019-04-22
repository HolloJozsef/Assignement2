package ro.utcn.springbootdemo.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.springbootdemo.entities.Menu;
import ro.utcn.springbootdemo.entities.Restaurant;
import ro.utcn.springbootdemo.repository.MenuRepository;
import ro.utcn.springbootdemo.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;

    public List<Restaurant> getAllRestaurants(){
        return Lists.newArrayList(restaurantRepository.findAll());
    }

    public Restaurant getByName(String name){
        return restaurantRepository.findOneByName(name).orElseThrow(()->new IllegalArgumentException(("Restaurant not found!.")));
    }
    public Restaurant getById(long id){
        return restaurantRepository.findById(id).orElseThrow(()->new IllegalArgumentException(("Restaurant not found!.")));
    }
    public void addOrCreateMenu(Restaurant restaurant,String name,int price){
        Menu menu=menuRepository.findOneWithRestaurantById(restaurant.getIdRestaurant()).orElseGet(() -> createMenu(name, price));
        restaurant.getMenu().add(menu);
        restaurantRepository.save(restaurant);
    }
    private Menu createMenu(String name,int price){
        Menu menu=new Menu();
        menu.setName(name);
        menu.setPrice(price);
        return menu;
    }
}

