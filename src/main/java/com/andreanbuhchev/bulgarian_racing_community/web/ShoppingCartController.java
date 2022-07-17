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

    //TODO SEE ALL PRODUCTS THAT ARE ADDED TO SHOPPING CART
    //TODO DELETE PRODUCT FROM SHOPPING CART
    //TODO DELETE ALL PRODUCTS FROM SHOPPING CART
    //TODO BUY ONE PRODUCT -> DELETE IT FROM THE LIST
    //TODO BUY ALL PRODUCTS -> DELETE ALL FROM THE LIST
    //TODO SHOW SUM AT BOTTOM TO CUSTOMER OF ALL PRODUCTS IN THE LIST PRICES

}
