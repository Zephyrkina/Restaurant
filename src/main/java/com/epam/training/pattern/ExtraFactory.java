package com.epam.training.pattern;

import com.epam.training.entity.Extra;

public class ExtraFactory{

    public Extra create(String extraName) {
        return new Extra(extraName);
    }
}
