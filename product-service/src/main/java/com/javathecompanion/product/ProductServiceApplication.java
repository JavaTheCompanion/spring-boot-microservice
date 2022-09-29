package com.javathecompanion.product;

import com.javathecompanion.product.service.ProductService;
import com.javathecompanion.product.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(final ProductService productService) {
        return args -> {
            final Product product1 = Product.builder()
                    .productName("Sony Bravia 139cm 4K Ultra HD Smart LED Google TV")
                    .price(99900.0)
                    .category("Electronics")
                    .subCategory("Televisions")
                    .build();

            productService.saveProduct(product1);

            final Product product2 = Product.builder()
                    .productName("Apple iPhone 13 Pro (128 GB) - Alpine Green")
                    .price(119900.0)
                    .category("Electronics")
                    .subCategory("Mobiles")
                    .build();

            productService.saveProduct(product2);
        };
    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
