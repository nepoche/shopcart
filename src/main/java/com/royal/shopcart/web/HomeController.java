package com.royal.shopcart.web;


import com.royal.shopcart.data.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CartItemRepository cartRepo;

    @Autowired
    public HomeController(CartItemRepository c) {
        cartRepo = c;
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }
}
