package com.epam.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtraDecorator implements Food {
    private Food food;
    private Food extra;

    @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return extra.getBonusHappiness(food.getBonusHappiness(currentHappiness));
    }

}

