package ro.utcn.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.springbootdemo.entities.Menu;
import ro.utcn.springbootdemo.entities.Order;
import ro.utcn.springbootdemo.repository.MenuRepository;
import ro.utcn.springbootdemo.repository.OrderRepository;

@Service
public class MenuService {
    private static long orderID=0;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Menu getById(long id){
        return menuRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Menu not found!"));
    }
    public void addOrCreateOrder(Menu menu,long orderID){
        Order order=orderRepository.findById(orderID).orElseGet(()->createOrder(menu,orderID));
        menu.getOrders().add(order);
       menuRepository.save(menu);

    }
    private Order createOrder(Menu menu,long orderID){
        Order order=new Order();
        order.setMenu(menu);
        order.setId(orderID);
        return order;
    }
}
