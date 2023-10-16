package hw63;
/**
 * Task1
 * Пусть есть класс BankAccount с полем String IBAN и класс
 * Person c полями name и List< BankAccount >. Нужно написать метод,
 * который вернет список IBANs с числами замененными звездочками
 * после 3 третьего символа
 */

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> listOfPitAccts = List.of(
                new BankAccount("DE12 3456 7890 9876 5432 12"),
                new BankAccount("IT12 3456 7890 9876 5432 12")
        );
        List<BankAccount> listOfAnnAccts = List.of(
                new BankAccount("ES12 3456 7890 9876 5432 12"),
                new BankAccount("GB12 3456 7890 9876 5432 12")
        );
        List<Person> people = List.of(
                new Person("Ann", listOfAnnAccts),
                new Person("Peter", listOfPitAccts));

        List<String> camouflagedIBANs = hideIBANs(people);
        camouflagedIBANs.forEach(System.out::println);
    }
    public static List<String> hideIBANs(List<Person> persons) {
        return persons.stream()
                .flatMap(person -> person.getBankAccounts().stream())
                .map(BankAccount::getIBAN)
                .map(s -> String.join("",
                        s.substring(0, 3),
                        s.substring(3).replaceAll("[0-9]", "*")))
                .collect(Collectors.toList());
    }
}
