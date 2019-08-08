package com.epam.training.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Dish implements Food {
    private String dishName;
    private String clientName;

    @Override
    public String getFoodName() {
        return dishName;
    }



   /* @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return dishType.getBonus().applyAsDouble(currentHappiness);
    }*/
}
