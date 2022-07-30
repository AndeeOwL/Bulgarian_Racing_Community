package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.view.ShoppingCartView;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCartView> findAll(UserDetails userDetails);

    double totalSum(List<ShoppingCartView> products);

    void deleteProduct(Long id,UserDetails userDetails);

    void deleteAllProducts(UserDetails userDetails);

    void deleteAllShoppingCartItems();
}
