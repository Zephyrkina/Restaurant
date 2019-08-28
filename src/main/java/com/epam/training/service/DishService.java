package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.repository.DishRepository;

public class DishService implements FoodService{
    private DishRepository dishRepository;

    public DishService() {
        dishRepository = new DishRepository();
    }

    public Double getBonusHappiness(Dish dish, Double currentHappiness) {
        return dishRepository.getDishes().get(dish.getDishName()).applyAsDouble(currentHappiness);
    }
}
