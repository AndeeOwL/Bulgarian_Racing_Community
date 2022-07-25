package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.view.ShoppingCartView;
import com.andreanbuhchev.bulgarian_racing_community.service.ShoppingCartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping()
    public String products(Model model, @AuthenticationPrincipal UserDetails userDetails){

        List<ShoppingCartView> products = shoppingCartService.findAll(userDetails);
        double totalSum = shoppingCartService.totalSum(products);

        model.addAttribute("allProducts", products);
        model.addAttribute("totalSum", totalSum);

        return "shopping-cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails){

        shoppingCartService.deleteProduct(id,userDetails);



        return "redirect:/shopping-cart";
    }

    @GetMapping("/deleteAll")
    public String deleteAllProducts(@AuthenticationPrincipal UserDetails userDetails){

        shoppingCartService.deleteAllProducts(userDetails);

        return "redirect:/shopping-cart";
    }

}
