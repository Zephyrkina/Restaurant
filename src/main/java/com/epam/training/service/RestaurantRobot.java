package com.epam.training.service;

import com.epam.training.entity.ExtraDecorator;
import com.epam.training.entity.Food;
import com.epam.training.entity.Order;
import com.epam.training.pattern.DishFactory;
import com.epam.training.pattern.ExtraFactory;
import com.epam.training.pattern.Factory;
import com.epam.training.pattern.OrderObserver;
import com.epam.training.repository.DishRepository;
import com.epam.training.repository.ExtraRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class RestaurantRobot {
    private Factory dishFactory;
    private Factory extraFactory;
    private List<OrderObserver> orderObservers;
    private DishRepository dishRepository;
    private ExtraRepository extraRepository;
    private OrderQueueService ordersQueue;

    public RestaurantRobot() {
        orderObservers = new ArrayList<>();
        dishFactory = new DishFactory();
        dishRepository = new DishRepository();
        extraRepository = new ExtraRepository();
        extraFactory = new ExtraFactory();
        ordersQueue = OrderQueueService.getInstance();
    }

    public void startProcessingOrders() {

        while (true) {
            if (ordersQueue.isEmpty()) {
                continue;
            } else {
                Order order = ordersQueue.getOrder();
                Food orderedDish = dishFactory.createFood(order.getDishName(), dishRepository.getDishes().get(order.getDishName()));
                if (order.getExtraName() != null && !order.getExtraName().isEmpty()) {
                    Food orderedExtra = extraFactory.createFood(order.getExtraName(), extraRepository.getExtras().get(order.getExtraName()));
                    orderedDish = new ExtraDecorator(orderedDish, orderedExtra);
                }

                order.setDish(orderedDish);

                log.info("Robot has prepared: {} (extra: {}) for {}", order.getDishName(),  order.getExtraName() != null ? order.getExtraName() : " - ", order.getClientName() );

                notifyObservers(order);

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
