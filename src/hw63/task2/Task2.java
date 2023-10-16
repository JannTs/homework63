package hw63.task2;

/**
 * Пусть есть класс Person с полями String name и int age.
 *
 * Написать метод, принимающий лист Persons и возвращающий суммарный возраст
 * тех, кто старше 17 лет
 * Написать метод, принимающий лист Persons и возвращающий имена тех,
 * кто старше 17 лет в виде строки.
 * Должна быть возвращена строка примерно такого вида:
 * In this list John and Peter and Ann are older than 17
 * (В этом списке Джон и Питер и Анн старше 17 лет)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Person> humans = createPersonsList();
        //Task2 -> 1. суммарный возраст тех, кто старше 17 лет
        int totalAge = totalAgeOlderThan17(humans);
        System.out.println("The summary age of people older than 17 years is " + totalAge);
        //Task2 -> 2.имена тех, кто старше 17 лет
        System.out.println(getNamesOfPersonsOlderThan17(humans));
        //-> 2* .имена тех, кто старше установленного критерия
        System.out.println(getNamesOfPeopleOlderThan(humans,17));
    }

    public static List<Person> createPersonsList() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("John", 25));
        persons.add(new Person("Peter", 30));
        persons.add(new Person("Ann", 18));
        persons.add(new Person("Benjamin", 16));
        persons.add(new Person("George", 15));
        return persons;
    }

    public static int totalAgeOlderThan17(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > 17)
                .mapToInt(Person::getAge)
                .sum();
    }

    public static String getNamesOfPersonsOlderThan17(List<Person> people) {
        String result = "In this list ";
        List<String> namesOlderThan17 = people.stream()
                .filter(person -> person.getAge() > 17)
                .map(Person::getName)
                .collect(Collectors.toList());
        result += String.join(" and ", namesOlderThan17) + " are older than 17";
        return result;
    }

    public static String getNamesOfPeopleOlderThan(List<Person> people, int аgeCriterion) {
        List<String> names = people.stream()
                .filter(person -> person.getAge() > аgeCriterion)
                .map(Person::getName)
                .collect(Collectors.toList());
        if (names.isEmpty()) {
            return "No one is older than "+ аgeCriterion+" years.";
        } else {
            String namesString = String.join(" and ", names);
            return "In this list " + namesString + " are older than "+аgeCriterion;
        }
    }

}