package com.epam.training;

import com.epam.training.entity.*;
import com.epam.training.service.OrderQueueService;
import com.epam.training.service.OrderService;
import com.epam.training.service.RestaurantRobot;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Client client1 = new Client("Fred", 0.0);
        Client client2 = new Client("Mike", 0.0);
        Client client3 = new Client("Joji", 0.0);


        RestaurantRobot robot = new RestaurantRobot();
        OrderService orderService = new OrderService();
        //OrderQueueService orderQueue = OrderQueueService.getInstance();

        robot.addObserver(client1);
        robot.addObserver(client2);
        robot.addObserver(client3);

        robot.startProcessingOrders();


        Order order1 = orderService.orderDish(client1.getName(), "hotdog");
        Order order2 = orderService.orderDish(client2.getName(),  "chips", "mustard");
        Order order3 = orderService.orderDish(client3.getName(), "hotdog", "mustard");



       /* orderQueue.addOrderToQueue(order1);
        orderQueue.addOrderToQueue(order2);
        orderQueue.addOrderToQueue(order3);




        robot.processOrder(order1);
        robot.processOrder(order2);
        robot.processOrder(order3);

        Order order4 = client1.orderDish(DishType.CHIPS, ExtraType.KETCHUP);

        robot.processOrder(order4);
*/
    }




}
