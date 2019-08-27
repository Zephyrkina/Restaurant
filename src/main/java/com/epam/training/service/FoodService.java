package com.epam.training.service;

import com.epam.training.entity.Dish;

public interface FoodService {
    Double getBonusHappiness(Dish dish, Double currentHappiness);
}
