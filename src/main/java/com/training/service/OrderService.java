package com.training.service;

import com.training.entity.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {
    private OrderQueue ordersQueue;

    public OrderService() {
        ordersQueue = OrderQueue.getInstance();
    }

    public void orderDish(Order order) {
        ordersQueue.addOrder(order);
        log.info("Client {} ordered food: {}", order.getClientName(), order.getDishName());
    }
}
