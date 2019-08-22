package com.epam.training.service;

import com.epam.training.entity.Food;

public interface FoodService {
    Double getBonusHappiness(Food food, Double currentHappiness);
}
