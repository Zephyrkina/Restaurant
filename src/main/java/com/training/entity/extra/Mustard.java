package com.training.entity.extra;

import com.training.entity.Client;
import com.training.entity.Eatable;

public class Mustard extends Extra {

    public Mustard(Eatable dish) {
        super(dish);
    }

    public Double increaseClientsHappiness(Client client) {
        Double initHappiness = client.getHappiness();
        Double extraHappiness = initHappiness + 1.0;
        client.setHappiness(extraHappiness);
        return extraHappiness;
    }
}
