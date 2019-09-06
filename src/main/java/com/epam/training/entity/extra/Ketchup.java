package com.epam.training.entity.extra;

import com.epam.training.entity.Client;
import com.epam.training.entity.Eatable;

public class Ketchup extends Extra {

    public Ketchup(Eatable dish) {
        super(dish);
    }

    public Double increaseClientsHappiness(Client client) {
        Double productHappiness = this.getDish().increaseClientsHappiness(client);
        Double extraHappiness = productHappiness * 2.0;
        client.setHappiness(extraHappiness);
        return extraHappiness;
    }
}
