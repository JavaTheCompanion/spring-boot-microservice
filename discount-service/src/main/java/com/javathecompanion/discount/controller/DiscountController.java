package com.javathecompanion.discount.controller;

import com.javathecompanion.discount.entity.Discount;
import com.javathecompanion.discount.service.DiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("discounts")
@Slf4j
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(final DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public Discount saveDiscount(@RequestBody final Discount discount) {
        log.info("saving Discount [{}]", discount);
        return this.discountService.saveDiscount(discount);
    }

    @GetMapping
    public List<Discount> fetchAllDiscounts() {
        log.info("fetching all Discounts");
        return this.discountService.fetchAllDiscounts();
    }

}
