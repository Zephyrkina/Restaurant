package com.epam.training.service;

import com.epam.training.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class OrderQueue {
    private Queue<Order> orders;
    private static volatile OrderQueue instance;

    private OrderQueue() {
        orders = new LinkedBlockingQueue<>();
    }

    public static OrderQueue getInstance() {
            if (instance == null) {
                synchronized (OrderQueue.class) {
                    if (instance == null) {
                        instance = new OrderQueue();
                    }
                }
            }
            return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
        log.info("Order has been added to queue: {} ", order.toString());
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public Order getOrder() {
        return orders.poll();
    }
}
