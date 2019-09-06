package com.epam.training.entity.product;

import com.epam.training.entity.Client;

public class Hotdog extends Product {

    public Double increaseClientsHappiness(Client client) {
        Double currentHappiness = client.getHappiness();
        Double newHappiness = currentHappiness + 2.0;
        Double bonusHappiness = newHappiness - currentHappiness;
        client.setHappiness(newHappiness);
        return bonusHappiness;
    }
}
