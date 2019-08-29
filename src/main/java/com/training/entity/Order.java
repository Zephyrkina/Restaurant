package com.training.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private String clientName;
    private String extraName;
    private String dishName;
}
