package com.javathecompanion.discount.service;

import com.javathecompanion.discount.repository.DiscountRepository;
import com.javathecompanion.discount.entity.Discount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(final DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount saveDiscount(final Discount discount) {
        return this.discountRepository.save(discount);
    }

    @Override
    public List<Discount> fetchAllDiscounts() {
        return this.discountRepository.findAll();
    }

}
