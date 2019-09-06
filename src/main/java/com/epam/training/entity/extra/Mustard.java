package com.epam.training.entity.extra;

import com.epam.training.entity.Client;
import com.epam.training.entity.Eatable;

public class Mustard extends Extra {

    public Mustard(Eatable dish) {
        super(dish);
    }

    public Double increaseClientsHappiness(Client client) {
        Double currentHappiness = client.getHappiness();
        Double extraHappiness = currentHappiness + 1.0;
        client.setHappiness(extraHappiness);
        return extraHappiness;
    }
}
