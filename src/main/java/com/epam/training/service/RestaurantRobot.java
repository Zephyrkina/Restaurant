package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Extra;
import com.epam.training.entity.Order;
import com.epam.training.pattern.DishFactory;
import com.epam.training.pattern.ExtraFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestaurantRobot {

    private DishFactory dishFactory;

    private ExtraFactory extraFactory;

    private ClientService clientService;

    private OrderQueue ordersQueue;

    public RestaurantRobot(ClientService clientService) {
        dishFactory = new DishFactory();
        extraFactory = new ExtraFactory();
        ordersQueue = OrderQueue.getInstance();
        this.clientService = clientService;
    }

    public void startProcessingOrders() {

        while (true) {
            if (!ordersQueue.isEmpty()) {
                Order order = ordersQueue.getOrder();
                Dish orderedDish = dishFactory.create(order.getDishName(), order.getClientName());

                if (order.getExtraName() != null && !order.getExtraName().isEmpty()) {
                    Extra orderedExtra = extraFactory.create(order.getExtraName());
                    orderedDish.setExtra(orderedExtra);
                }

                log.info("Robot has prepared: {} (extra: {}) for {}", orderedDish.getDishName(), orderedDish.getExtra() != null ? orderedDish.getExtra().getName() : " - ", orderedDish.getClientName());

                clientService.update(orderedDish);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
