package com.training.pattern;

import com.training.entity.Eatable;

public interface OrderObserver {
    void update(String clientName, Eatable dish);
}
