package com.epam.training.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Extra implements Food {
    private String extraName;

    @Override
    public String getFoodName() {
        return extraName;
    }

   /* @Override
    public FoodType getFoodType() {
        return extra;
    }

    @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return extra.getBonus().applyAsDouble(currentHappiness);
    }*/
}
