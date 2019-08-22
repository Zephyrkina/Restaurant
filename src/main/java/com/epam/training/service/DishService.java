package com.epam.training.service;

import com.epam.training.entity.Food;
import com.epam.training.repository.DishRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DishService implements FoodService{
    private DishRepository dishRepository;

    public DishService() {
        dishRepository = new DishRepository();
    }

    public Double getBonusHappiness(Food dish, Double currentHappiness) {
        Double newHappiness = dishRepository.getDishes().get(dish.getName()).applyAsDouble(currentHappiness);
        return newHappiness;

    }


}
