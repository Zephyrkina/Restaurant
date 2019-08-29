package com.training.service;

import com.training.entity.Client;
import com.training.entity.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClientService {
    private List<Client> clients;
    private HappinessCalculator happinessCalculator;

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

    public void update(Dish dish) {
        for (Client client : clients) {
            if (client.getName().equals(dish.getClientName())) {
                Double currentHappiness = happinessCalculator.calculateHappiness(dish, client.getHappiness());
                client.setHappiness(currentHappiness);
                log.info("Client {} ate dish, current happiness is {}", client.getName(), client.getHappiness());
            }
        }
    }

}
