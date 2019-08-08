package com.epam.training.pattern;

import com.epam.training.entity.Food;

public interface Factory {
    Food createFood(String foodName);
}

