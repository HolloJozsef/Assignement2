package ro.utcn.springbootdemo.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.springbootdemo.entities.User;
import ro.utcn.springbootdemo.repository.UserRepository;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service("userDetailsService")
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return Lists.newArrayList(userRepository.findAll());
    }

    public User getById(long id){
        return userRepository.findUserById(id).orElseThrow(()->new IllegalArgumentException("User not found. Id:"+ id));
    }
    public User getByEmail(String email){
        return userRepository.findUserByEmail(email).orElseThrow(()->new IllegalArgumentException("User not found. Id:"+ email));
    }
    @Transactional(readOnly=true)
    public User loadUserByEmail(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(username).get();
        AuthorityUtils.createAuthorityList(user.getType());
        return user;

    }


    public User loadUserByUsername(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}
