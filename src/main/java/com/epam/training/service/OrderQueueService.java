package com.epam.training.service;

import com.epam.training.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class OrderQueueService {
    private Queue<Order> orders;
    private static volatile OrderQueueService instance;

    private OrderQueueService() {
        orders = new LinkedBlockingQueue<>();
    }

    public static OrderQueueService getInstance() {
            if (instance == null) {
                synchronized (OrderQueueService.class) {
                    if (instance == null) {
                        instance = new OrderQueueService();
                    }
                }
            }
            return instance;
    }

    public void addOrderToQueue(Order order) {
        orders.add(order);
        log.info("Order has been added to queue: {} ", order.toString());

    }

 /*   public void removeOrderFromQueue() {
        orders.remove();
    }*/

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public Order getOrder() {
        return orders.poll();
    }
}
