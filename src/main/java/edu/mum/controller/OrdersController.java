package edu.mum.controller;

import edu.mum.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/orders"})
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping(value = "all-orders", method = RequestMethod.GET)
    public String listAllOrders(Model model) {
        System.out.println(ordersService.findAll());
        model.addAttribute("orderList", ordersService.findAll());
        return "all-orders";
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public String listOrdersForMember(@PathVariable(value = "username") String username, Model model) {
        System.out.println(ordersService.findAll());
        model.addAttribute("orderList", ordersService.findCompletedOrderForUser(username));
        return "my-orders";
    }

    @RequestMapping(value = "cart/{username}", method = RequestMethod.GET)
    public String getCartForUser(@PathVariable(value = "username") String username, Model model) {
        System.out.println(ordersService.findAll());
        model.addAttribute("order", ordersService.findInProgressOrderForUser(username));
        System.out.println("FINISHED CART");
        return "cart";
    }


    @RequestMapping(value = "/placeOrder/{username}", method = RequestMethod.GET)
    public String placeOrder(@PathVariable(value = "username") String username, Model model) {

        ordersService.updateToCompleted(username);
        model.addAttribute("order", null);

        return "card";


    }
}
