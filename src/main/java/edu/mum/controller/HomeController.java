package edu.mum.controller;

import edu.mum.domain.Members;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Product;

@Controller
public class HomeController {


    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

//        model.addAttribute("greeting", "Welcome to our community, Kimosabe!!");
//        model.addAttribute("tagline", "The one and only place to live, work and play!!");

        return "index";
    }

    @RequestMapping({"/products"})
    public String product(Model model) {
        return "products";
    }


    @RequestMapping({"/user-orders"})
    public String userOrders(Model model) {
        return "user-orders";
    }

    @RequestMapping({"/all-orders"})
    public String allOrders(Model model) {
        return "all-orders";
    }

    @RequestMapping({"/cart"})
    public String cart(Model model) {
        return "cart";
    }

    @RequestMapping({"/wish-list"})
    public String wishList(Model model) {
        return "wish-list";
    }

    @RequestMapping({"/about"})
    public String about(Model model) {
        return "about";
    }

    @RequestMapping({"/signup"})
    public String signup(@ModelAttribute("newMember") Members member, Model model) {
        return "signup";
    }

    @ModelAttribute("homeTestOrder")
    public String testOrder() {

        // test interceptor Orders
        System.out.println("CONTROLLER @MODELATTRIBUTE PREHANDLE");

        return "This is CONTROLLER ORDER!";
    }


}
