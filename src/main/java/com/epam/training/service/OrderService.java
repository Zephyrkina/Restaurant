package com.epam.training.service;

import com.epam.training.entity.Order;

public class OrderService {

    public Order orderDish(DishType dishType) {

        Order o = restaurant.orderDIsh(bob.getName(), burger);

        Order order = new Order();
        order.setClient(this);
        order.setDishType(dishType);
        orderQueue.addOrderToQueue(order);
        log.info("Client ordered food: " + dishType.getName());
        return order;
    }

    public Order orderDish(FoodType dishType, FoodType extraType) {
        Order order = new Order();
        order.setClient(this);
        order.setDishType(dishType);
        order.setExtraType(extraType);
        orderQueue.addOrderToQueue(order);
        log.info("Client " + this.name + " ordered food: " + dishType.getName() + ", extra: " + extraType.getName() );
        return order;
    }
}
