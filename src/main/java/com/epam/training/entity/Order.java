package com.epam.training.entity;

import com.epam.training.entity.extra.ExtraType;
import com.epam.training.entity.product.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Client client;
    private ProductType productType;
    private ExtraType extraType;
}
