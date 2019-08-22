package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Extra;
import com.epam.training.entity.Food;
import com.epam.training.entity.Order;
import com.epam.training.pattern.DishFactory;
import com.epam.training.pattern.ExtraFactory;
import com.epam.training.pattern.Factory;
import com.epam.training.pattern.OrderObserver;
import com.epam.training.repository.DishRepository;
import com.epam.training.repository.ExtraRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@AllArgsConstructor
public class RestaurantRobot {

    private Factory dishFactory;

    private Factory extraFactory;

    private ClientService clientService;

    private OrderQueueService ordersQueue;

    public RestaurantRobot(ClientService clientService) {
        dishFactory = new DishFactory();
        extraFactory = new ExtraFactory();
        ordersQueue = OrderQueueService.getInstance();
        this.clientService = clientService;
    }

    public void startProcessingOrders() {

        while (true) {
            if (ordersQueue.isEmpty()) {
                continue;
            } else {
                Order order = ordersQueue.getOrder();
                Food orderedDish = dishFactory.createFood(order.getDishName());

                if (order.getExtraName() != null && !order.getExtraName().isEmpty()) {
                    Extra orderedExtra = (Extra)extraFactory.createFood(order.getExtraName());
                    ((Dish)orderedDish).setExtra(orderedExtra);

                }

                order.setDish(orderedDish);

                clientService.update(order);

                log.info("Robot has prepared: {} (extra: {}) for {}", order.getDishName(),  order.getExtraName() != null ? order.getExtraName() : " - ", order.getClientName() );

            }


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
