package com.epam.training.service;

import com.epam.training.entity.Dish;
import com.epam.training.entity.Extra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtraServiceTest {
    private DishService dishService;
    private ExtraService extraService;
    private Dish dish;

    @Before
    public void setUp() {
        dishService = new DishService();
        extraService = new ExtraService(dishService);
        Extra extra = new Extra("ketchup");
        dish =  new Dish("hotdog", extra, "Carlo");
    }

    @Test
    public void testGetBonusHappiness_whenDishContainsExtra() {
        Double expectedHappiness = 4.0;
        Double actualHappiness;

        actualHappiness = extraService.getBonusHappiness(dish, 0.0);

        assertEquals(expectedHappiness, actualHappiness);
    }



}