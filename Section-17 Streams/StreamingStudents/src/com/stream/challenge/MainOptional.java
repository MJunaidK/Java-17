package com.stream.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .collect(Collectors.toList());

        Optional<Student> o1 = getStudent(null, "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());
        System.out.println(o1);
       // System.out.println(o1.get());
        //o1.ifPresent(System.out::println);
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("---> Empty"));

        Optional<Student> o2 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o2.isPresent());
        System.out.println(o2);
       // System.out.println(o2.get());
        o2.ifPresent(System.out::println);

        //students.add(0, null);
        Optional<Student> o3 = getStudent(students, "first");
        System.out.println("Empty = " + o3.isEmpty() + ", Present = " + o3.isPresent());
        System.out.println(o3);
        o3.ifPresent(System.out::println);

        //Student firstStudent = (o2.isPresent() ? o2.get() : null);
        //Student firstStudent = o2.orElse(getDummyStudent(jmc));
        Student firstStudent = o2.orElseGet(() -> getDummyStudent(jmc));
        long id = firstStudent.getStudentId();
        System.out.println("FirstStudent id is  "+ id);

        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",", l) )
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Missing FR"));

    }

    private static Optional<Student> getStudent(List<Student> list, String type){

        if(list == null || list.isEmpty()){
            return Optional.empty();
        } else if (type.equals("first")) {
            //return Optional.of(list.getFirst());
            return Optional.ofNullable(list.getFirst());
        } else if (type.equals("last")) {
            //return Optional.of(list.getLast());
            return Optional.ofNullable(list.getLast());
        }

        //return Optional.of(list.get(new Random().nextInt(list.size())));
        return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    private static Student getDummyStudent(Course ... courses){

        System.out.println("Getting the dummy student");
        return new Student("NO", 1, 1, "U", false, courses);
    }
}
