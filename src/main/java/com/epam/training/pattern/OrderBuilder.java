package com.epam.training.pattern;

import com.epam.training.entity.Order;

public class OrderBuilder {
    private Order order;

    public OrderBuilder() {
        order = new Order();
    }

    public OrderBuilder setClientName(String clientName) {
        order.setClientName(clientName);
        return this;
    }

    public OrderBuilder setDishName(String dishName) {
        order.setDishName(dishName);
        return this;
    }

    public OrderBuilder setExtraName(String extraName) {
        order.setExtraName(extraName);
        return this;
    }

    public Order build() {
        return order;
    }
}
