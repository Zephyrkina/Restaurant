package com.training.pattern;

import com.training.entity.Extra;

public class ExtraFactory{

    public Extra create(String extraName) {
        return new Extra(extraName);
    }
}
