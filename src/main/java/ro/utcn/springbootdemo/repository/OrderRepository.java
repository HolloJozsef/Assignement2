package ro.utcn.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ro.utcn.springbootdemo.entities.Menu;
import ro.utcn.springbootdemo.entities.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Long> {
        Optional<Order> findById(@Param("id") Long id);
        Optional<Order> findOrderById(@Param("id") Long id);

}
