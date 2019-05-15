package ro.utcn.springbootdemo.entities;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "numeMeniu")
    private String name;
    @Column(name="price")
    private int price;
    @ManyToOne
    @JoinColumn(name="restaurant")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu")
    private List<Order> orders;

    public Menu(String name, int price, Restaurant restaurant, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Menu(String name, int price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Menu(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Menu( String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Menu() {
    }



    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
