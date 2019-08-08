package com.epam.training.pattern;

import com.epam.training.entity.Food;

import java.util.function.DoubleUnaryOperator;

public interface Factory {
    Food createFood(String foodName, DoubleUnaryOperator bonus);
}

