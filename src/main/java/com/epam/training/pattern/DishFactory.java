package com.epam.training.pattern;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Food;


public class DishFactory implements Factory {

    @Override
    public Food createFood(String dishName) {
        return new Dish(dishName);
    }
}
