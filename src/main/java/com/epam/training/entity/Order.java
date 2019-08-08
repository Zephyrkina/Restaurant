package com.epam.training.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Order {
    private String clientName;
    private Food dish;
    private String extraName;
    private String dishName;

}
