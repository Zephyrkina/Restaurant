package com.training.entity;


import com.training.pattern.OrderObserver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Client implements OrderObserver{
    private String name;
    private Double happiness;

    @Override
    public void update(String clientName, Eatable dish) {
        if (clientName.equals(this.name)) {
            dish.increaseClientsHappiness(this);
            log.info("{}'s happiness after dish is {}", this.name, this.happiness);
        }
    }
}
