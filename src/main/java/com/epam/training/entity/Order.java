package com.epam.training.entity;

import lombok.Data;

@Data
public class Order {
    private String clientName;
    private Food dish;
    private String extraName;
    private String dishName;

}
