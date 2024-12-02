package com.stream.challenge;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in java ");

        List<Student> students1 = Stream
                .iterate(1, s -> s <= 5000, s -> s + 1)
                .map(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);
                //.sum();

        double avgPercent = totalPercent/students.size();
        System.out.printf("Average percent complete = %.2f%% %n", avgPercent);

        int topPercent = (int) (1.25 * avgPercent);
        System.out.printf("Best Percentage Completed = %d%% %n", topPercent);

        Comparator<Student> longTermStudent
                    = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

        hardWorkers.forEach(s -> {
            s.addCourse(jgames);
            System.out.print(s.getStudentId() + " ");
        });

        System.out.println();

        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(
            Student::getStudentId
        );

        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
//                .toList()
//                .collect(Collectors.toList())
//                .collect(Collectors.toSet())
//                .collect(() -> new TreeSet<>(uniqueSorted), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
                s.addCourse(jgames);
                System.out.print(s.getStudentId() + " ");
        });
    }
}
