package com.epam.training.entity;

import lombok.*;

@Data
public class Dish {
    private String dishName;
    private Extra extra;
    private String clientName;

    public Dish(String dishName, String clientName) {
        this.dishName = dishName;
        this.clientName = clientName;
    }

    public Dish(String dishName, Extra extra, String clientName) {
        this.dishName = dishName;
        this.extra = extra;
        this.clientName = clientName;
    }
}
