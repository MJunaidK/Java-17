package com.generics.example;

import com.generics.staticmethods.QueryItem;
import com.generics.staticmethods.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem{

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i=0; i< studentCount; i++){
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printMoreLists(students);
        //printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i=0; i< studentCount; i++){
            lpaStudents.add(new LPAStudent());
        }
        printMoreLists(lpaStudents);
        //printList(lpaStudents);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);

        //new Arraylist will be inferred to be upperbound we declared, a queryItem and that is what we get back
        // When the type can't be inferred we can specify the type argument before the method invocation ater the class name and dot
        // <Student>getMatches is saying that the new list that will be get created in the get matches method will be a list of students now.
        // This is how to specify a type argument for a generic method that is also a static method on the class
        // In most case type can be inferred from the argument being passed
        var students2022 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2022");
        printMoreLists(students2022);

        //QueryList<Employee> employeeList = new QueryList<>();
    }

    // Type argument example,
    public static void printMoreLists(List<? extends Student> students){

        // this one will not let you add an element
//        Student last = students.get(students.size()-1);
//        students.set(0, last);

        for(var student: students){
            System.out.println(student.getYearStarted() + ": " + student);
        }

        System.out.println();
    }

        // Type parameter example
//    public static<T extends Student> void printList(List<T> students){
//        for(var student: students){
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//
//        System.out.println();
//    }


    // Type ersaure at run time. These are not overloaded method because of type ersuare hence will not compile
//    public static void testList(List<String> list){
//
//        for(var element: list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//
//        for(var element: list){
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }

        public static void testList(List<?> list){

            for(var element: list){
                if(element instanceof String s){
                    System.out.println("String " + s.toUpperCase());
                } else if(element instanceof Integer i){
                    System.out.println("Integer " + i.floatValue());
                }
            }
        }
}
