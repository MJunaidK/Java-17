package com.stream.challenge;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect{

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> australianStudents = students.stream()
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());

        System.out.println("# of Australian students = " + australianStudents.size());

        long count = students.stream()
                .filter((s) -> s.getCountryCode().equals("AU"))
                .count();

        System.out.println(count);

        Set<Student> underThirty = students.stream()
                        .filter((s) -> s.getAgeEnrolled() < 30)
                                .collect(Collectors.toSet());

        System.out.println("# of Under Thirty students = " + underThirty.size());

        Set<Student> youngAussues1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussues1.addAll(australianStudents);
        youngAussues1.retainAll(underThirty);
        youngAussues1.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        Set<Student> youngAussues2 = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);

        youngAussues2.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r,v) -> r + " " + v);

        System.out.println("countryList = " + countryList );




    }
}
