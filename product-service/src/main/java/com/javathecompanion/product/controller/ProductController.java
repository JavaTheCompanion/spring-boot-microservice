package com.javathecompanion.product.controller;

import com.javathecompanion.product.service.ProductService;
import com.javathecompanion.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody final Product product) {
        log.info("saving Product [{}]", product);
        return this.productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> fetchAllProducts() {
        log.info("fetching all Products");
        return this.productService.fetchAllProducts();
    }

}
