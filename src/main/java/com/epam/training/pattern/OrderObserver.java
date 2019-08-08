package com.epam.training.pattern;

import com.epam.training.entity.Order;

public interface OrderObserver {
    void update(Order order);
}
