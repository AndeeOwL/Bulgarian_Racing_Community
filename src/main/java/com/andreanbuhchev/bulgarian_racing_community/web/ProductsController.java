package com.andreanbuhchev.bulgarian_racing_community.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping()
    public String products(){
        return "products";
    }

    //TODO SEE ALL PRODUCTS
    //TODO ADD PRODUCT USER,ADMIN
    //TODO DELETE PRODUCT USER CAN DELETE HIS ,ADMIN CAN DELETE ALL
    //TODO ADD PRODUCT TO SHOPPING CART

}
