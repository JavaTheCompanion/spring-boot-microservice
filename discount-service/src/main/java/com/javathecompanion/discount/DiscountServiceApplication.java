package com.javathecompanion.discount;

import com.javathecompanion.discount.entity.Discount;
import com.javathecompanion.discount.service.DiscountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(final DiscountService discountService) {
        return args -> {
            final Discount discount1 = Discount.builder()
                    .productId(1L)
                    .discountPct(39.0)
                    .build();

            discountService.saveDiscount(discount1);

            final Discount discount2 = Discount.builder()
                    .productId(2L)
                    .discountPct(13.0)
                    .build();

            discountService.saveDiscount(discount2);
        };
    }

}
