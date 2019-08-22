package com.epam.training.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Dish implements Food {
    private String name;
    private Extra extra;

    public Dish(String name) {
        this.name = name;
    }
}
