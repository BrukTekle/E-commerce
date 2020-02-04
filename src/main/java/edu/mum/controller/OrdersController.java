package edu.mum.controller;

import edu.mum.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/orders"})
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping(value = "all-orders", method = RequestMethod.GET)
    public String listMembers(Model model) {
        System.out.println(ordersService.findAll());
        model.addAttribute("orderList", ordersService.findAll());
        return "all-orders";
    }
}
