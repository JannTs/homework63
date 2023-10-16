package hw63;

import java.util.List;

public class Person {
    String name;
    List<BankAccount> bankAccounts;

    public Person(String name, List<BankAccount> bankAccounts) {
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public String getName(){
        return name;
    }

    public List<BankAccount> getBankAccounts(){
        return bankAccounts;
    }
}