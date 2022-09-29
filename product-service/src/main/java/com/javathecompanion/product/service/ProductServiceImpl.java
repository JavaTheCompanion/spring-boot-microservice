package com.javathecompanion.product.service;

import com.javathecompanion.product.dto.Discount;
import com.javathecompanion.product.repository.ProductRepository;
import com.javathecompanion.product.entity.Product;
import com.javathecompanion.product.service.client.DiscountServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final DiscountServiceClient discountServiceClient;
    private final ProductRepository productRepository;

    public ProductServiceImpl(DiscountServiceClient discountServiceClient, ProductRepository productRepository) {
        this.discountServiceClient = discountServiceClient;
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        final Map<Long, Double> discountData = this.discountServiceClient.getDiscountData();

        log.info("fetching all Products");
        final List<Product> products = this.productRepository.findAll();

        for (final Product product : products) {
            if (discountData.containsKey(product.getId())) {
                final double discountPct = discountData.get(product.getId());
                product.setDiscountPct(discountPct);

                final double discountPrice = product.getPrice() - ((product.getPrice() * discountPct) / 100);
                product.setDiscountPrice(discountPrice);
            } else {
                product.setDiscountPct(0.0);
                product.setDiscountPrice(product.getPrice());
            }
        }

        return products;
    }

}