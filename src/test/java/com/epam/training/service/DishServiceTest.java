package com.epam.training.service;

import com.epam.training.entity.Dish;
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
        Double actualHappiness;

        actualHappiness = dishService.getBonusHappiness(dish, 0.0);

        assertEquals(expectedHappiness, actualHappiness);
    }

    @Test(expected = Exception.class)
    public void testGetBonusHappiness_whenDishIsWrong() {
        //тестирую логику не того класса ?

        DishService dishService = new DishService();
        Dish dish = new Dish("wrongName", "Carlo");
        Double expectedHappiness = 2.0;
        Double actualHappiness;

        actualHappiness = dishService.getBonusHappiness(dish, 0.0);
    }

}