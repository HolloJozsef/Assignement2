package ro.utcn.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.springbootdemo.entities.Order;

public interface OrderRepository extends CrudRepository<Order,Long> {

}
