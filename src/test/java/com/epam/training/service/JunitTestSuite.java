package com.epam.training.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
        {
                DishServiceTest.class,
                ExtraServiceTest.class,
                HappinessCalculatorTest.class
        }
)
public class JunitTestSuite {
}
