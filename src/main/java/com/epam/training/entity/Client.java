package com.epam.training.entity;


import com.epam.training.pattern.OrderObserver;
import com.epam.training.service.HappinessCalculator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Client implements OrderObserver{
    private String name;
    private Double happiness;

    public void increaseHappiness(Double happiness) {
        this.happiness += happiness;
    }


    @Override
    public void update(Order order) {
        Double newHappiness = HappinessCalculator.calculateHappiness(this.happiness, order.getDish());
        increaseHappiness(newHappiness);
    }
}
