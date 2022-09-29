package com.javathecompanion.product.service;

import com.javathecompanion.product.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> fetchAllProducts();

}
