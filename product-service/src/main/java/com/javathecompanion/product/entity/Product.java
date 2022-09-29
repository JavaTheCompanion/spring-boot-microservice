package com.javathecompanion.product.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String productName;
    private String category;
    private String subCategory;
    private double price;
    @Transient
    private double discountPct;
    @Transient
    private double discountPrice;

}
