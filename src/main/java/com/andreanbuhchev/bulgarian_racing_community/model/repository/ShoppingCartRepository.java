package com.andreanbuhchev.bulgarian_racing_community.model.repository;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUserEntityUsername(String username);
}
