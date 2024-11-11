package com.methodreferences.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{

    private static int last_id = 1;

    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(System.out::println);

        calculator((a,b) -> a+b, 10, 25);
        calculator(Integer::sum, 10, 25);

        calculator((a,b) -> a+b, 2.5, 7.5);
        calculator(Double::sum, 2.5, 7.5);

        Supplier<PlainOld> reference1 = () -> new PlainOld();
        Supplier<PlainOld> reference2 = PlainOld::new;

        PlainOld newPojo = reference1.get();

        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator((s1, s2) -> s1 +s2, "Hello ", "World");;
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");;
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BinaryOperator<String> b2 = String::concat;

        BiFunction<String, String, String> b3 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b4 = String::concat;

        //UnaryOperator<String> u1 = String::concat;(two arg methods not allowed)
        //UnaryOperator<String> u2 = (s1) -> s1 +s2;

        UnaryOperator<String> u3 = (s1) -> s1.toUpperCase();
        UnaryOperator<String> u4 = String::toUpperCase;

        System.out.println(b1.apply("Hello", "World"));
        System.out.println(b2.apply("Hello", "World"));

        System.out.println(u3.apply("Hello"));
        System.out.println(u4.apply("Hello"));

        String result = "Hello".transform(u3);
        System.out.println(result);

        result = result.transform(String::toLowerCase);
        System.out.println(result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = "+ resultBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){

        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}