package com.epam.training.pattern;

import com.epam.training.entity.Extra;
import com.epam.training.entity.Food;

public class ExtraFactory implements Factory{

    @Override
    public Food createFood(String foodName) {
        return new Extra(foodName);
    }
}
