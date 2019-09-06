package com.epam.training;

import com.epam.training.entity.*;
import com.epam.training.entity.extra.ExtraType;
import com.epam.training.entity.product.ProductType;
import com.epam.training.service.OrderQueue;
import com.epam.training.service.RestaurantRobot;

public class App {

    public static void main(String[] args) {
        Client client1 = new Client("Fred", 0.0);
        Client client2 = new Client("Mike", 0.0);
        Client client3 = new Client("Joji", 0.0);

        RestaurantRobot robot = new RestaurantRobot();
        OrderQueue orderQueue = OrderQueue.getInstance();

        robot.addObserver(client1);
        robot.addObserver(client2);
        robot.addObserver(client3);

        Thread robotThread = new Thread(() -> robot.startProcessingOrders());

        robotThread.start();

        Order order1 = new Order(client1, ProductType.HOT_DOG, ExtraType.UNDEFINED);
        Order order2 = new Order(client2, ProductType.CHIPS, ExtraType.MUSTARD);
        Order order3 = new Order(client3, ProductType.HOT_DOG, ExtraType.KETCHUP);

        orderQueue.addOrder(order1);
        orderQueue.addOrder(order2);
        orderQueue.addOrder(order3);
    }




}
