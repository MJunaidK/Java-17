package com.enums.example;

public enum Topping {

    MUSTARD,
    PICKLE,
    BACON,
    CHEDDAR,
    TOMATO;

    public double getPrice(){
        return switch (this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }

}
