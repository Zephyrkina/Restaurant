package com.training.service;

import com.training.entity.Dish;

public interface FoodService {
    Double getBonusHappiness(Dish dish, Double currentHappiness);
}
