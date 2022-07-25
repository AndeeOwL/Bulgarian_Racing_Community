package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.Event;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Product;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.ShoppingCart;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ShoppingCartRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ShoppingCartView;
import com.andreanbuhchev.bulgarian_racing_community.service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ModelMapper modelMapper;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ModelMapper modelMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<ShoppingCartView> findAll(UserDetails userDetails) {

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        List<Event> events = shoppingCart.getEvents();

        List<Product> products = shoppingCart.getProducts();

        List<ShoppingCartView> shoppingCartViews = new ArrayList<>();

        events.forEach(event -> {
            ShoppingCartView shoppingCartView = new ShoppingCartView();
            modelMapper.map(event,shoppingCartView);
            shoppingCartView.setSeller(event.getUserEntity().fullName());
            shoppingCartView.setType("event");
            shoppingCartView.setId(event.getId());


            shoppingCartViews.add(shoppingCartView);
        });

        products.forEach(product -> {
            ShoppingCartView shoppingCartView = new ShoppingCartView();
            modelMapper.map(product,shoppingCartView);
            shoppingCartView.setSeller(product.getUserEntity().fullName());
            shoppingCartView.setType("product");
            shoppingCartView.setId(product.getId());


            shoppingCartViews.add(shoppingCartView);
        });



        return shoppingCartViews;
    }

    @Override
    public double totalSum(List<ShoppingCartView> products) {

        double sum = products.stream().mapToDouble(ShoppingCartView::getPrice).sum();

        return sum;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id,UserDetails userDetails) {

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        List<ShoppingCartView> products = findAll(userDetails);

        ShoppingCartView shoppingCartView = products.get(Math.toIntExact(id) - 1);

        if (shoppingCartView.getType().equals("event")){
            shoppingCart.getEvents().remove(id-1);
        } else if (shoppingCartView.getType().equals("product")) {
            shoppingCart.getProducts().remove(id-1);
        }

        //TODO METHOD NOT REMOVING ! CORRECT ID AND INDEXES !

    }

    @Override
    @Transactional
    public void deleteAllProducts(UserDetails userDetails) {

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        shoppingCart.getProducts().clear();
        shoppingCart.getEvents().clear();
    }
}
