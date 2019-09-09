package com.training.entity.extra;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ExtraType {
    MUSTARD("mustard"), KETCHUP("ketchup"), UNDEFINED("");

    private String extraType;
}
