package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.ExtraDecorator;
import com.epam.training.entity.Food;
import com.epam.training.repository.DishRepository;
import com.epam.training.repository.ExtraRepository;

public class HappinessCalculator {
    private DishRepository dishRepository;
    private ExtraRepository extraRepository;

    public HappinessCalculator() {
        dishRepository = new DishRepository();
        extraRepository = new ExtraRepository();
    }

    public  Double calculateHappiness(Double currentHappiness, Food food) {
        Double newHappiness = dishRepository.getDishes().get(((Dish)food).getDishName()).applyAsDouble(currentHappiness);

        if (food instanceof ExtraDecorator) {
            newHappiness = extraRepository.getExtras().get(((ExtraDecorator)food).getExtra().getFoodName()).applyAsDouble(newHappiness);
        }

        return newHappiness;
    }
}
