package com.epam.training.entity;

import lombok.*;

import java.util.function.DoubleUnaryOperator;

@Data
@AllArgsConstructor
public class Dish implements Food {
    private String dishName;
    private DoubleUnaryOperator bonus;

    @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return bonus.applyAsDouble(currentHappiness);
    }
}
