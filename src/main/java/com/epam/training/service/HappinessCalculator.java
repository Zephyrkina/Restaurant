package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Food;
import com.epam.training.repository.DishRepository;
import com.epam.training.repository.ExtraRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class HappinessCalculator {
    private FoodService dishService;

    public HappinessCalculator() {
        dishService = new DishService();
    }

    public Double calculateHappiness(Food dish, Double currentHappiness ) {
        if (((Dish)dish).getExtra() != null ) {
             dishService = new ExtraService(dishService);
        }

        Double newHappiness = dishService.getBonusHappiness(dish, currentHappiness);

        return newHappiness;
    }
}
