package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.ProductDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Product;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.ShoppingCart;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ProductRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ShoppingCartRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ProductsView;
import com.andreanbuhchev.bulgarian_racing_community.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ShoppingCartRepository shoppingCartRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void buyProduct(Long id, UserDetails userDetails) {

        Product product = productRepository.findById(id).orElseThrow();

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        shoppingCart.getProducts().add(product);

    }

    @Override
    public void addProduct(ProductDto addProductModel, UserDetails userDetails) {
        Product newProduct = new Product();

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).
                orElseThrow();

        modelMapper.map(addProductModel,newProduct);
        newProduct.setUserEntity(user);



        productRepository.save(newProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductsView> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductsView> productsViews = new ArrayList<>();

        products.forEach(product -> {
            ProductsView productsView = new ProductsView();
            modelMapper.map(product,productsView);
            productsView.setSeller(product.getUserEntity().fullName());
            productsViews.add(productsView);
        });
        return productsViews;
    }
}
