package com.epam.training;

import com.epam.training.entity.*;
import com.epam.training.service.OrderQueueService;
import com.epam.training.service.OrderService;
import com.epam.training.service.RestaurantRobot;

public class App {

    public static void main(String[] args) {
        Client client1 = new Client("Fred", 0.0);
        Client client2 = new Client("Mike", 0.0);
        Client client3 = new Client("Joji", 0.0);

        RestaurantRobot robot = new RestaurantRobot();
        OrderService orderService = new OrderService();


        robot.addObserver(client1);
        robot.addObserver(client2);
        robot.addObserver(client3);

        Thread robotThread = new Thread(() -> robot.startProcessingOrders());

        robotThread.start();


        Order order1 = orderService.orderDish(client1.getName(), "hotdog");
        Order order2 = orderService.orderDish(client2.getName(),  "chips", "mustard");
        Order order3 = orderService.orderDish(client3.getName(), "hotdog", "mustard");


    }




}
