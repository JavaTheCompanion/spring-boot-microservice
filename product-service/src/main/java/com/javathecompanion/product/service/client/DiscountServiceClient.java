package com.javathecompanion.product.service.client;

import com.javathecompanion.product.dto.Discount;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class DiscountServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "productServiceCircuitBreaker") //, fallbackMethod = "getDiscountFallback")
    //@Retry(name = "retryGetDiscountFromProductService", fallbackMethod = "getDiscountFallback")
    public Map<Long, Double> getDiscountData() {
        log.info("calling Discount Service");
        final ResponseEntity<Discount[]> restExchange = this.restTemplate
                .getForEntity("http://DISCOUNT-SERVICE/discounts", Discount[].class);

        return Stream.of(restExchange.getBody()).collect(Collectors.toMap(Discount::getProductId, Discount::getDiscountPct));
    }

    private Map<Long, Double> getDiscountFallback(final Throwable e) {
        log.error("Discount Service is unavailable, sending empty Discount data from fallback method");
        return new HashMap<>();
    }

}