package com.training.service;

import com.training.entity.Dish;
import com.training.entity.Extra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HappinessCalculatorTest {
    private HappinessCalculator happinessCalculator;
    private DishService dishService;
    private Dish dish;

    @Before
    public void setUp() {
        happinessCalculator = new HappinessCalculator();
        dishService = new DishService();
        dish = new Dish("hotdog", "Carlo");
    }

    @Test
    public void testHappinessCalculator_whenDishWithoutExtra() {
        Double expectedHappiness = 2.0;

        Double actualHappiness = happinessCalculator.calculateHappiness(dish, 0.0);

        assertEquals(expectedHappiness, actualHappiness);
    }

    @Test
    public void testHappinessCalculator_whenDishWithExtra() {
        Extra extra = new Extra("mustard");
        dish.setExtra(extra);
        Double expectedHappiness = 1.0;

        Double actualHappiness = happinessCalculator.calculateHappiness(dish, 0.0);

        assertEquals(expectedHappiness, actualHappiness);
    }

}