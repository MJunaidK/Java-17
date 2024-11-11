package com.lambda.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                 new Main.Person("Mohammad", "Junaid"),
                new Main.Person("Hunny", "Khan"),
                new Main.Person("Bada", "Bhaishaab"),
                new Main.Person("Ghatto", "Rani"),
                new Main.Person("Yussu", "Ghadhi")
        ));

        // Using anonymous class

        var comparatorLastName = new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        people.sort(new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        });

        people.sort((o1,o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);

        //@FunctionalInterface
        interface EnhancedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);

    }
}
