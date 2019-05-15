package ro.utcn.springbootdemo.entities;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private long id;
    @ManyToOne
    @JoinColumn(name="id")
    private Menu menu;

    public Order(Menu menu) {
        this.menu = menu;
    }

    public Order(Menu menu, long id) {
        this.id=id;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}