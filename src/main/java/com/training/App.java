package com.training;

import com.training.entity.*;
import com.training.pattern.OrderBuilder;
import com.training.service.ClientService;
import com.training.service.OrderService;
import com.training.service.RestaurantRobot;
import com.training.entity.Client;
import com.training.entity.Order;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Client client1 = new Client("Fred", 0.0);
        Client client2 = new Client("Mike", 0.0);
        Client client3 = new Client("Joji", 0.0);


        OrderService orderService = new OrderService();
        ClientService clientService = new ClientService();
        RestaurantRobot robot = new RestaurantRobot(clientService);

        clientService.addClient(client1);
        clientService.addClient(client2);
        clientService.addClient(client3);

        Thread robotThread = new Thread(() -> robot.startProcessingOrders());

        robotThread.start();

        Order order1 = new OrderBuilder()
                .setClientName(client1.getName())
                .setDishName("hotdog")
                .build();

        Order order2 = new OrderBuilder()
                .setClientName(client2.getName())
                .setDishName("chips")
                .setExtraName("mustard")
                .build();


        Order order3 = new OrderBuilder()
                .setClientName(client3.getName())
                .setDishName("hotdog")
                .setExtraName("ketchup")
                .build();


      /*  Order order1 = new Order(client1.getName(), "hotdog");
        Order order2 = new Order(client2.getName(), "chips", "mustard");
        Order order3 = new Order(client3.getName(), "hotdog", "mustard");*/

        orderService.orderDish(order1);
        orderService.orderDish(order2);
        orderService.orderDish(order3);

        /*Order order1 = orderService.orderDish(client1.getName(), "hotdog");
        Order order2 = orderService.orderDish(client2.getName(),  "chips", "mustard");
        Order order3 = orderService.orderDish(client3.getName(), "hotdog", "mustard");*/



    }




}
