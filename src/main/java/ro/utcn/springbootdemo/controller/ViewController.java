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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.utcn.springbootdemo.entities.Menu;
import ro.utcn.springbootdemo.entities.Restaurant;
import ro.utcn.springbootdemo.entities.User;
import ro.utcn.springbootdemo.service.MenuService;
import ro.utcn.springbootdemo.service.RestaurantService;
import ro.utcn.springbootdemo.service.UserService;

@Controller
public class ViewController {


    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
  /*
@RequestMapping("/login")
public String login(Model model) {
    List<User> users=userService.getAllUsers();
    model.addAttribute("users",users);
    return "login";
}*/
    /*
    @RequestMapping("/login/{email}")
    public String login(@PathVariable("email") String email,Model model) {

        List<User> users=userService.getAllUsers();
        for(User user : users){
            if(user.getEmail().equals(email))
                if(user.getPassword().equals(userService.getByEmail(email).getPassword()))
                    return "restaurant_details";

        }

    }*/
    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }

    @RequestMapping({ "/home" })
    public String hello(Model model)
    {
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", allRestaurants);
        return "home";
    }


    @RequestMapping(path = "/details/{restaurantId}", produces = "text/html")
    public String restaurantDetails(@PathVariable("restaurantId") long restaurantId, Model model)
    {
        Restaurant restaurant=restaurantService.getById(restaurantId);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("menus", restaurant.getMenu());
       // System.out.println(restaurant.getMenu().toString());
       // model.addAttribute("newMapping", new RestaurantMenuDTO(restaurant, "",0));
        return "restaurant_details";
    }

    @RequestMapping(path = "/order/{menuId}", produces = "text/html")
    public String orderDetails(@PathVariable("menuId") long menuId, Model model)
    {
        Menu menu=menuService.getById(menuId);
        menuService.addOrCreateOrder(menu);
        model.addAttribute("menu", menu);
        model.addAttribute("order",menu.getOrders());
        //model.addAttribute("menus", restaurant.getMenu());
        // System.out.println(restaurant.getMenu().toString());
        // model.addAttribute("newMapping", new RestaurantMenuDTO(restaurant, "",0));
        return "order_details";
    }
    /*
    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String createPost()
    {
        postsService.addOrCreateTag(newMapping.getPost(), newMapping.getTagName());
        Long postId = newMapping.getPost().getId();
        return "redirect:/details/" + postId;
    }
*/
}