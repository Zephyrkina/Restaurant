package com.epam.training.entity.extra;


import com.epam.training.entity.Eatable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Extra implements Eatable {
    private Eatable dish;
}

