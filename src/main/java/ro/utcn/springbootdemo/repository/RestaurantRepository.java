package ro.utcn.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.springbootdemo.entities.Restaurant;

import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findOneByName(String name);
}
