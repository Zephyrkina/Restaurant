package com.epam.training.service;

import com.epam.training.entity.Food;
import com.epam.training.entity.Order;

public class ClientService {
    public void consumeDish(Food dish){
        this.happiness = dish.getBonusHappiness(this.happiness);
        log.info("Client " + this.name + " ate dish, current happines is " + this.happiness);
    }

    @Override
    public void update(Order order) {
        if (name.equals(order.getClient().getName())){
            consumeDish(order.getDish());
        }
    }

}
