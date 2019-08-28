package com.epam.training.service;

import com.epam.training.entity.Dish;

public class HappinessCalculator {
    private FoodService dishService;

    public HappinessCalculator() {
        dishService = new DishService();
    }

    public Double calculateHappiness(Dish dish, Double currentHappiness) {
        if (dish.getExtra() != null) {
            dishService = new ExtraService(dishService);
        }
        return dishService.getBonusHappiness(dish, currentHappiness);
    }
}
