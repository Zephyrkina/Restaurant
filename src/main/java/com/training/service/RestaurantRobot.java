package com.training.service;

import com.training.entity.Eatable;
import com.training.entity.Order;
import com.training.entity.extra.ExtraType;
import com.training.entity.product.ProductType;
import com.training.pattern.DishFactory;
import com.training.pattern.OrderObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class RestaurantRobot {
    private DishFactory dishFactory;
    private List<OrderObserver> orderObservers;
    private OrderQueue ordersQueue;

    public RestaurantRobot() {
        orderObservers = new ArrayList<>();
        dishFactory = new DishFactory();
        ordersQueue = OrderQueue.getInstance();
    }

    public void addObserver(OrderObserver orderObserver) {
        orderObservers.add(orderObserver);
    }

    public void removeObserver(OrderObserver orderObserver) {
        orderObservers.remove(orderObserver);
    }

    public void startProcessingOrders() {

        while (true) {
            if (!ordersQueue.isEmpty()) {
                Order order = ordersQueue.getOrder();

                Eatable orderedDish = dishFactory.createDish(order.getProductType(), order.getExtraType());

                log.info("Robot has prepared: {} (extra: {}) for {}", order.getProductType(), order.getExtraType(),
                        order.getClient().getName() );

                notifyObservers(order.getClient().getName(), orderedDish);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyObservers(String clientName, Eatable dish) {
        for (OrderObserver o : orderObservers) {
            o.update(clientName, dish);
        }
    }
}
