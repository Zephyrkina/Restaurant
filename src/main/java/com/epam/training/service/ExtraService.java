package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.repository.ExtraRepository;

public class ExtraService implements FoodService {
    private FoodService dishService;
    private ExtraRepository extraRepository;

    public ExtraService(FoodService dishService) {
        this.dishService = dishService;
        extraRepository = new ExtraRepository();
    }

    @Override
    public Double getBonusHappiness(Dish dish, Double currentHappiness) {
        Double happinessFromDish = dishService.getBonusHappiness(dish, currentHappiness);
        return extraRepository.getExtras().get(dish.getExtra().getName()).applyAsDouble(happinessFromDish);
    }
}
