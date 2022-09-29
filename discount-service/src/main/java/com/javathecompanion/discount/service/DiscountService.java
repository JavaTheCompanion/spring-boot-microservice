package com.javathecompanion.discount.service;

import com.javathecompanion.discount.entity.Discount;

import java.util.List;

public interface DiscountService {

    Discount saveDiscount(Discount discount);

    List<Discount> fetchAllDiscounts();

}
