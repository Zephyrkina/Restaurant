package com.training.entity;

import com.training.entity.extra.ExtraType;
import com.training.entity.product.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Client client;
    private ProductType productType;
    private ExtraType extraType;
}