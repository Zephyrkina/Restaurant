package com.epam.training.service;

import com.epam.training.entity.Client;
import com.epam.training.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class ClientService {
    private List<Client> clients;
    private HappinessCalculator happinessCalculator;

    public ClientService(HappinessCalculator happinessCalculator) {
        clients = new ArrayList<>();
        this.happinessCalculator = happinessCalculator;
    }

    public ClientService() {
        clients = new ArrayList<>();
        happinessCalculator = new HappinessCalculator();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);

    }

    public void update(Order order) {
        for (Client client : clients) {
            if (client.getName().equals(order.getClientName())){
                Double happinessBeforeFood = client.getHappiness();
                Double currentHappiness = happinessCalculator.calculateHappiness(order.getDish(), happinessBeforeFood);
                log.info("Client " + order.getClientName() + " ate dish, current happines is " + currentHappiness);
            }
        }
    }
}
