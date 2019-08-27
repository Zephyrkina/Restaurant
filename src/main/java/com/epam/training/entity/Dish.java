package com.epam.training.entity;

import lombok.*;

@Data
public class Dish {
    private String name;
    private Extra extra;
    private String clientName;

    public Dish(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }
}
