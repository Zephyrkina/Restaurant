package com.training.entity.product;

import com.training.entity.Client;

public class Hotdog extends Product {

    public Double increaseClientsHappiness(Client client) {
        Double initHappiness = client.getHappiness();
        Double afterProductHappiness = initHappiness + 2.0;
        Double bonusHappiness = afterProductHappiness - initHappiness;
        client.setHappiness(afterProductHappiness);
        return bonusHappiness;
    }
}
