package com.epam.training.repository;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

@Data
public class ExtraRepository {
    private Map<String, DoubleUnaryOperator> extras;

    public ExtraRepository() {
        extras = new HashMap<>();
        extras.put("ketchup", (dishBonus) -> dishBonus * 2.0);
        extras.put("mustard", (dishBonus) -> 1.0 );
    }
}
