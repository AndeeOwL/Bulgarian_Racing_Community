package com.andreanbuhchev.bulgarian_racing_community.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @GetMapping()
    public String shoppingCart(){
        return "shopping-cart";
    }

    //TODO SEE ALL PRODUCTS
    //TODO DELETE PRODUCT FROM SHOPPING CART USER CAN DELETE HIS ,ADMIN CAN DELETE ALL
    //TODO DELETE ALL PRODUCTS FROM SHOPPING CART
    //TODO BUY ALL PRODUCTS

}
