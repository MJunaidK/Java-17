package com.generics.staticmethods;

import com.generics.example.Student;

import java.util.ArrayList;
import java.util.List;

// Any type that use this class must be student or sub type of student class and it also must implement the query item interface
public class QueryList <T extends Student & QueryItem>{

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    // The generic class type parameter only has meaning for instance and therefore for an instance method, at the class level this is unknown
    // When the generic class loaded into memory, it is not loaded with any type parameter so you can't use it in a static method
    //public static List<T> getMatches(List<T> items, String field, String value){

    // But we can make this as a generic method by adding a type parameter. This means that T type parameter is a totally different type completely separate from the type parameter declared for the class QueryList
    // This type get specified or inferred when you invoke this static method on the class
    // Even though our generic class does not have a S type it does not matter
    // A Generic method type is unrelated to the type declared on the generic class
    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
        List<S> matches = new ArrayList<>();
        for(var item: items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();
        for(var item: items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
