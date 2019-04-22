package ro.utcn.springbootdemo.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="restaurant")
public class Restaurant {

    @Id
    @Column(name="idRestaurant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRestaurant;

    @Column(name="name")
    private String name;

    @Column(name="adresa")
    private String adresa;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menu;

    public Restaurant(String name, String adresa, List<Menu> menu) {
        this.name = name;
        this.adresa = adresa;
        this.menu = menu;
    }

    public Restaurant() {
    }

    private Restaurant(Builder builder){
        this.name = builder.name;
        this.adresa = builder.adresa;
        this.menu = builder.menu;
        this.idRestaurant = builder.idRestaurant;

    }

    public long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public class Builder{

        private long idRestaurant;
        private String name;
        private String adresa;
        private List<Menu> menu;

        public Builder(String name, String adresa, List<Menu> menu, long idRestaurant) {
            this.name = name;
            this.adresa = adresa;
            this.menu = menu;
            this.idRestaurant = idRestaurant;
        }

        public Restaurant build(){
            return new Restaurant(this);
        }

    }


}
