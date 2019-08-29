package com.training.pattern;

import com.training.entity.Dish;

public class DishFactory {

    public Dish create(String dishName, String clientName) {
        return new Dish(dishName, clientName);
    }
}
