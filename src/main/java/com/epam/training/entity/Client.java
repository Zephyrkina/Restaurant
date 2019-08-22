package com.epam.training.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Client {
    private String name;
    private Double happiness;

}
