package com.royal.shopcart.web;

import com.royal.shopcart.data.CartItemRepository;
import com.royal.shopcart.data.ProductRepository;
import com.royal.shopcart.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductRepository prodRepo;
    private final CartItemRepository cartRepo;

    @Autowired
    public CartController(ProductRepository p, CartItemRepository c) {
        prodRepo = p;
        cartRepo = c;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cart", cartRepo.findAll());
        model.addAttribute("total", findTotalPrice());
        return "cart/index";
    }

    @GetMapping("/remove")
    public String removeItem(@RequestParam Long id) {
//        Optional<CartItem> c = cartRepo.findById(id);
//        if (c.isPresent()) {
//            cartRepo.deleteById(c.get().getId());
//            return "redirect:/cart";
//        }
        cartRepo.deleteById(id);
        return "redirect:/cart";
    }

    @GetMapping("/removeAll")
    public String clearCart() {
        cartRepo.deleteAll();
        return "redirect:/";
    }

    public Double findTotalPrice() {
        Iterator iterator = cartRepo.findAll().iterator();
        Double sum = 0D;

        while (iterator.hasNext()) {
            sum += ((CartItem) iterator.next()).getPrice();
        }
        return sum;
    }

}
