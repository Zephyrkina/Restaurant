package com.epam.training.pattern;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Food;

import java.util.function.DoubleUnaryOperator;


public class DishFactory implements Factory {

    @Override
    public Food createFood(String dishName, DoubleUnaryOperator bonus) {
        return new Dish(dishName, bonus);
    }
}
