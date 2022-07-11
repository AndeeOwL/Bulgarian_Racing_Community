package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.ProductDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProductService {
    void buyProduct(Long id, UserDetails userDetails);

    void addProduct(ProductDto addProductModel, UserDetails userDetails);

    void deleteProduct(Long id);
}
