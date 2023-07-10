package com.learn.java.functionalprogramming;

import java.util.List;
import java.util.Optional;

public class PrintOperations {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 9, 10, 11, 18, 17, 14, 13);
        printAllElementsInListStructured(list);
        System.out.println();
        printAllElementsInListFunctional(list);
        System.out.println();
        printEvenElementsStructured(list);
        System.out.println();
        printEvenElementsFunctional(list);
        System.out.println();
        printEvenElementsFunctionalUsingLambda(list);
        System.out.println();
        printOddElementsFunctionalUsingLambda(list);
        System.out.println();

        List<String> courses = List.of("AWS","Java","Angular","JavaScript","Spring Boot");
        printCoursesFunctional(courses);
        System.out.println();
        printCoursesWithSubString(courses);
        System.out.println();
        printCoursesWithLengthFunctional(courses);
        System.out.println();

        printSqauresOfElements(list);
        System.out.println();
        printCubesOfEvenElements(list);
        System.out.println();
        printCharactersInCourses(courses);
        System.out.println();

        // Optional class
        System.out.println("Playing with Optional Class");
        List<String> fruits = List.of("Apple", "Banana", "Mango", "Peach");
        Optional<String> optional = fruits.stream()
                                            .filter(fruit -> fruit.startsWith("C"))
                                            .findFirst();
        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        optional.ifPresent(System.out::println);
        Optional<String> fruit = Optional.of("Banana");
        System.out.println(fruit.get());
        Optional<String> emptyString = Optional.empty(); // return error if accessed
    }

    private static void printCharactersInCourses(List<String> courses) {
        courses.stream()
                .map(course -> course + ": " + course.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfEvenElements(List<Integer> list) {
        list.stream()
                .filter(element -> element % 2 == 0)
                .map(element -> element * element * element)
                .forEach(System.out::println);
    }

    private static void printSqauresOfElements(List<Integer> list) {
        list.stream()
                .map(element -> element * element)
                .forEach(System.out::println);
    }

    private static void printCoursesWithLengthFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() > 4)
                .forEach(System.out::println);
    }

    private static void printCoursesFunctional(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printCoursesWithSubString(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printOddElementsFunctionalUsingLambda(List<Integer> list) {
        list.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printEvenElementsFunctionalUsingLambda(List<Integer> list) {
        list.stream()
                .filter(number -> number % 2 == 0) // Lambda expression
                .forEach(System.out::println);
    }

    private static void printAllElementsInListStructured(List<Integer> elements) {
        // simply loop the numbers and print them
        for (Integer element: elements) {
            System.out.println(element);
        }
    }

    private static void printAllElementsInListFunctional(List<Integer> elements) {
        // convert the list into a stream (sequence of numbers) and print each element using method reference
        elements.stream()
                .forEach(PrintOperations::printElement);

        System.out.println();
        // else in other way
        elements.stream()
                .forEach(System.out::println);
    }

    private static void printEvenElementsStructured(List<Integer> elements) {
        for (Integer element: elements) {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }
    }

    private static void printEvenElementsFunctional(List<Integer> elements) {
        elements.stream()
                .filter(PrintOperations::isEven) // only allow even numbers
                .forEach(System.out::println); // print the result numbers
    }

    private static boolean isEven(Integer number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    private static void printElement(int element) {
        System.out.println(element);
    }
}
