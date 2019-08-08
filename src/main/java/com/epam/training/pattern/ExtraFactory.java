package com.epam.training.pattern;

import com.epam.training.entity.Extra;
import com.epam.training.entity.ExtraDecorator;
import com.epam.training.entity.Food;

import java.util.function.DoubleUnaryOperator;

public class ExtraFactory implements Factory{

    @Override
    public Food createFood(String foodName, DoubleUnaryOperator bonus) {
        return new Extra(foodName, bonus);
    }
}
