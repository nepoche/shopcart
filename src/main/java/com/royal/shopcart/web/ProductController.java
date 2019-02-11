package com.royal.shopcart.web;

import com.royal.shopcart.data.CartItemRepository;
import com.royal.shopcart.data.ProductRepository;
import com.royal.shopcart.entities.CartItem;
import com.royal.shopcart.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/shop")
public class ProductController {

    private final ProductRepository prodRepo;
    private final CartItemRepository cartRepo;

    @Autowired
    public ProductController(ProductRepository p, CartItemRepository c) {
        prodRepo = p;
        cartRepo = c;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", prodRepo.findAll());
        return "shop/index";
    }

    @GetMapping("/add")
    public String addItem(@RequestParam("id") Long id) {
        Optional<CartItem> item = cartRepo.findById(id);
        if (item.isPresent()) {
            cartRepo.delete(item.get());
            CartItem toSave = item.get();
            toSave.setQuantity(item.get().getQuantity()+1);
            cartRepo.save(toSave);
            return "redirect:/shop";
        } else {
            Optional<Product> p = prodRepo.findById(id);
            if (p.isPresent()) {
                cartRepo.save(new CartItem(p.get(), 1));
                return "redirect:/shop";
            } else {
                return "shop/index";
            }
        }
    }

}
