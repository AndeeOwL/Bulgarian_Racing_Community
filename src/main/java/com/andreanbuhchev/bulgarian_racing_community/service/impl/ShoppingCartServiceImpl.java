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
import java.util.concurrent.atomic.AtomicReference;

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

       return products.stream().mapToDouble(ShoppingCartView::getPrice).sum();

    }

    @Override
    @Transactional
    public void deleteProduct(Long id,UserDetails userDetails) {

         ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

         List<ShoppingCartView> products = findAll(userDetails);

         AtomicReference<ShoppingCartView> shoppingCartView = new AtomicReference<>(new ShoppingCartView());

         products.forEach(p -> {
             if (p.getId().equals(id)) {
                 shoppingCartView.set(p);
             }
         });

         if (shoppingCartView.get().getType().equals("event")){

             var eventToRemove = shoppingCart.
                     getEvents().
                     stream().
                     filter(e -> id.equals(e.getId())).
                     toList();

             shoppingCart.getEvents().removeAll(eventToRemove);
             shoppingCartRepository.save(shoppingCart);

         } else if (shoppingCartView.get().getType().equals("product")) {

             var productToRemove = shoppingCart.
                     getProducts().
                     stream().
                     filter(e -> id.equals(e.getId())).
                     toList();

             shoppingCart.getProducts().removeAll(productToRemove);
             shoppingCartRepository.save(shoppingCart);

         }
     }

    @Override
    @Transactional
    public void deleteAllProducts(UserDetails userDetails) {

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        shoppingCart.getProducts().clear();
        shoppingCart.getEvents().clear();
    }
    @Override
    @Transactional
    public void deleteAllShoppingCartItems(){
        List <ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        shoppingCarts.forEach(shoppingCart -> {
            shoppingCart.getEvents().clear();
            shoppingCart.getProducts().clear();
        });
    }
}
