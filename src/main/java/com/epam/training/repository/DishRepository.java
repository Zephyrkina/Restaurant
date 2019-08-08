package com.epam.training.repository;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

@Data
public class DishRepository {
    private Map<String, DoubleUnaryOperator> dishes;

    public DishRepository() {
        dishes = new HashMap<>();
        dishes.put("hotdog", happ -> happ + 2.0);
        dishes.put("chips", happ -> happ * 1.05 );
    }
}
