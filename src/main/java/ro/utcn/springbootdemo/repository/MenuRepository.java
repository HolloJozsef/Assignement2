package ro.utcn.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ro.utcn.springbootdemo.entities.Menu;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    Optional<Menu> findOneWithRestaurantById(@Param("id") Long id);

}
