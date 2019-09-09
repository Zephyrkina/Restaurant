package com.training.entity.extra;


import com.training.entity.Eatable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Extra implements Eatable {
    private Eatable dish;
}

