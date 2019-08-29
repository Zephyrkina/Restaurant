package com.training.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private String name;
    private Double happiness;
}
