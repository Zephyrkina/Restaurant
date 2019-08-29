package com.training.service;

import com.training.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class OrderQueue {
    private Queue<Order> orderQueue;
    private static volatile OrderQueue instance;

    private OrderQueue() {
        orderQueue = new LinkedBlockingQueue<>();
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
        orderQueue.add(order);
        log.info("Order has been added to queue: {} ", order.toString());
    }

    public boolean isEmpty() {
        return orderQueue.isEmpty();
    }

    public Order getOrder() {
        return orderQueue.poll();
    }
}
