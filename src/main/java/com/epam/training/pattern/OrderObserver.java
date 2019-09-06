package com.epam.training.pattern;

import com.epam.training.entity.Eatable;

public interface OrderObserver {
    void update(String clientName, Eatable dish);
}
