package com.epam.training.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.DoubleUnaryOperator;

@Data
@AllArgsConstructor
public class Extra implements Food {
    private String extraName;
    private DoubleUnaryOperator bonus;

   @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return bonus.applyAsDouble(currentHappiness);
    }
}

