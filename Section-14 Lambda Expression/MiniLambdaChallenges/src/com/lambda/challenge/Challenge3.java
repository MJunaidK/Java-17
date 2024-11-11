package com.lambda.challenge;

import java.util.function.Supplier;

public class Challenge3 {

    public static void main(String[] args) {
        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava2 = () -> {return "I love Java!";};

        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());
    }
}
