package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.ProductDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ProductsView;
import com.andreanbuhchev.bulgarian_racing_community.service.ProductService;
import com.andreanbuhchev.bulgarian_racing_community.service.ShoppingCartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String products(Model model){
        List<ProductsView> products = productService.findAll();

        model.addAttribute("allProducts", products);
        return "products";
    }

    @GetMapping("/buy/{id}")
    public String buyProducts(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){

        productService.buyProduct(id,userDetails);

        return "redirect:/products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        if (!model.containsAttribute("addProductModel")) {
            model.addAttribute("addProductModel", new ProductDto());
        }

        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductDto addProductModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addProductModel", addProductModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductModel",
                    bindingResult);
            return "redirect:/products/add";
        }

        productService.addProduct(addProductModel, userDetails);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return "redirect:/products";
    }

}
