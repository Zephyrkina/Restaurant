package com.epam.training.pattern;

import com.epam.training.entity.Dish;

public class DishFactory {

    public Dish create(String dishName, String clientName) {
        return new Dish(dishName, clientName);
    }
}
