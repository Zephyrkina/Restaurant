package com.epam.training.entity;


import com.epam.training.pattern.OrderObserver;
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
        log.info("{} happiness is {} now", name, happiness);
    }

    @Override
    public void update(Order order) {
        if (order.getClientName().equals(this.name)) {
            Double newHappiness = order.getDish().getBonusHappiness(this.happiness);
            increaseHappiness(newHappiness);
        }
    }
}
