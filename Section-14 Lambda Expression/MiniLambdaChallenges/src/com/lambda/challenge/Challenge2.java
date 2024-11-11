package com.lambda.challenge;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Challenge2 {

    public static void main(String[] args) {
        //Function<String,String> everySecondChar = source -> {

        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i=0; i< source.length(); i++){
                if(i%2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));

        String result = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result);
    }

    public static String everySecondChar(String source){

        StringBuilder returnVal = new StringBuilder();
        for(int i=0; i< source.length(); i++){
            if(i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}
