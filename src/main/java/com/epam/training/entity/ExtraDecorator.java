package com.epam.training.entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class ExtraDecorator implements Food{
    private Food food;
    private Food extra;




   /* @Override
    public FoodType getFoodType() {
        return food.getFoodType();
    }*/

 /*   @Override
    public Double getBonusHappiness(Double currentHappiness) {
        return extra.getBonusHappiness(food.getBonusHappiness(currentHappiness));
    }
*/
    @Override
    public String getFoodName() {
        return null;
    }
}
