package com.epam.training.service;

import com.epam.training.entity.Client;
import com.epam.training.entity.Dish;
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
            if (client.getName().equals(dish.getClientName())){
                clientConsumesDish(client, dish);
            }
        }
    }

    private void clientConsumesDish(Client client, Dish dish) {
        Double happinessBeforeFood = client.getHappiness();
        Double currentHappiness = happinessCalculator.calculateHappiness(dish, happinessBeforeFood);
        client.setHappiness(currentHappiness);
        log.info("Client " + client.getName() + " ate dish, current happiness is " + client.getHappiness());
    }
}
