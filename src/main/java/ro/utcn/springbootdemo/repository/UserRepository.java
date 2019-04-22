package ro.utcn.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ro.utcn.springbootdemo.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
        Optional<User> findUserById(@Param("id") Long id);
        Optional<User> findUserByEmail(@Param("email") String email);
        User findByName(String name);
}

