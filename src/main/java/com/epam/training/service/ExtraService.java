package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Extra;
import com.epam.training.entity.Food;
import com.epam.training.repository.ExtraRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraService implements FoodService {
    private FoodService dishService;
    private ExtraRepository extraRepository;

    public ExtraService(FoodService dishService) {
        this.dishService = dishService;
        extraRepository = new ExtraRepository();

    }

    @Override
    public Double getBonusHappiness(Food food, Double currentHappiness) {
        Double happinessFromDish = dishService.getBonusHappiness(food, currentHappiness);
        Double newHappiness = extraRepository.getExtras().get(((Dish)food).getExtra().getName()).applyAsDouble(happinessFromDish);
        return newHappiness;
    }
}
