/*************************************************************************
 * ULLINK CONFIDENTIAL INFORMATION
 * _______________________________
 *
 * All Rights Reserved.
 *
 * NOTICE: This file and its content are the property of Ullink. The
 * information included has been classified as Confidential and may
 * not be copied, modified, distributed, or otherwise disseminated, in
 * whole or part, without the express written permission of Ullink.
 ************************************************************************/
package ro.utcn.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.utcn.springbootdemo.entities.Menu;
import ro.utcn.springbootdemo.entities.Order;
import ro.utcn.springbootdemo.entities.Restaurant;
import ro.utcn.springbootdemo.repository.MenuRepository;
import ro.utcn.springbootdemo.repository.OrderRepository;
import ro.utcn.springbootdemo.service.*;

@Controller
public class ViewController {


    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;
    public Cache cache=new Cache();
    @Autowired
    public MenuRepository menuRepository;
    @Autowired
    public OrderRepository orderRepository;
    @RequestMapping("/login")
    public String login() {

        return "login";
    }
    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }

    @RequestMapping({ "/home" })
    public String hello(Model model)
    {

        List <Restaurant> list=new ArrayList<>();
        System.out.println((System.currentTimeMillis()-cache.getTime())/1000+" ");
        if(System.currentTimeMillis()-cache.getTime()<30000 && cache.getCacheList()!=null){
            list=cache.getCacheList();
            System.out.println("Cache");
        }else{
            list = restaurantService.getAllRestaurants();
            cache.setCacheList(list);
            cache.setTime(System.currentTimeMillis());
            System.out.println("Database");
        }
        model.addAttribute("restaurants", list);
        return "home";
    }


    @RequestMapping(path = "/details/{restaurantId}", produces = "text/html")
    public String restaurantDetails(@PathVariable("restaurantId") long restaurantId, Model model)
    {
        Restaurant restaurant=restaurantService.getById(restaurantId);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("menus", restaurant.getMenu());
        return "restaurant_details";
    }

    @RequestMapping(path = "/order/{menuId}", produces = "text/html")
    public String orderDetails(@PathVariable("menuId") long menuId, Model model)
    {
        CsvFileWriter csvFileWriter=new CsvFileWriter();
        csvFileWriter.writeCsvFile("order.csv",(List<Order>)orderRepository.findAll());
        Menu menu=menuService.getById(menuId);
        menuService.addOrCreateOrder(menu,menuId);
        model.addAttribute("menu", menu);
        model.addAttribute("order",menu.getOrders());
        return "order_details";
    }

}