package com.epam.training.service;

import com.epam.training.entity.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {

    private OrderQueueService ordersQueue;

    public OrderService() {
        ordersQueue = OrderQueueService.getInstance();
    }

    public Order orderDish(String clientName, String foodName) {
        Order order = new Order();
        order.setClientName(clientName);
        order.setDishName(foodName);
        log.info("Client {} ordered food: {}", clientName, foodName);
        ordersQueue.addOrderToQueue(order);
        return order;
    }

    public Order orderDish(String clientName, String foodName, String extraName) {

        Order order = new Order();
        order.setClientName(clientName);
        order.setDishName(foodName);
        order.setExtraName(extraName);
        log.info("Client {} ordered food: {}, extra: {} " , clientName, foodName, extraName);
        ordersQueue.addOrderToQueue(order);
        return order;
    }
}
