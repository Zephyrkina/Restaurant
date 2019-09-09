package com.training.entity.product;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ProductType {
    HOT_DOG("hotdog"), CHIPS("chips");

    private String productName;
}
