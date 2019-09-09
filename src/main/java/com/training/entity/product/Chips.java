package com.training.entity.product;

import com.training.entity.Client;

public class Chips extends Product {

    public Double increaseClientsHappiness(Client client) {
        Double initHappiness = client.getHappiness();
        Double afterProductHappiness = initHappiness * 1.05;
        Double bonusHappiness = afterProductHappiness - initHappiness;
        client.setHappiness(afterProductHappiness);
        return bonusHappiness;
    }
}
