package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.ExtraDecorator;
import com.epam.training.entity.Food;
import com.epam.training.entity.Order;
import com.epam.training.pattern.DishFactory;
import com.epam.training.pattern.ExtraFactory;
import com.epam.training.pattern.Factory;
import com.epam.training.pattern.OrderObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class RestaurantRobot {

    private Factory dishFactory;

    private Factory extraFactory;

    private List<OrderObserver> orderObservers;

    public RestaurantRobot() {
        orderObservers = new ArrayList<>();
        dishFactory = new DishFactory();
        extraFactory = new ExtraFactory();
    }

    public void startProcessingOrders(OrderQueueService ordersQueue) {

        while (true) {
            if (ordersQueue.isEmpty()) {
                continue;
            } else {
                Order order = ordersQueue.getOrder();
                Food orderedDish = dishFactory.createFood(order.getDishName());

                if (!order.getExtraName().isEmpty()) {
                    Food orderedExtra = extraFactory.createFood(order.getExtraName());
                    orderedDish = new ExtraDecorator(orderedDish, orderedExtra);
                }

                order.setDish(orderedDish);

                notifyObservers(order);

                log.info("Robot has prepared: {} (extra: {}) for ..", order.getDishName(),  order.getExtraName() != null ? order.getExtraName() : " - " );

            }


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addObserver(OrderObserver orderObserver) {
        orderObservers.add(orderObserver);
    }

    public void removeObserver(OrderObserver orderObserver) {
        orderObservers.remove(orderObserver);
    }

    public void notifyObservers(Order order) {
        for (OrderObserver o : orderObservers) {
            o.update(order);
        }
    }
}
