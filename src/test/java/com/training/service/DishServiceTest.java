package com.training.service;

import com.training.entity.Dish;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DishServiceTest {
    private DishService dishService;
    private Dish dish;


    @Before
    public void setUp() {
        dishService = new DishService();
        dish = new Dish("hotdog", "Carlo");
    }

    @Test
    public void testGetBonusHappiness() {
        Double expectedHappiness = 2.0;

        Double actualHappiness = dishService.getBonusHappiness(dish, 0.0);

        assertEquals(expectedHappiness, actualHappiness);
    }
}