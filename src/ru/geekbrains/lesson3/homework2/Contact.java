package ru.geekbrains.lesson3.homework2;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    Set<Integer> numbers;

    public void addNumber(Integer number) {
        this.numbers.add(number);
    }

    public Set<Integer> getNumbers() {

        return this.numbers;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Contact(String name){
        this.name = name;
        this.numbers = new HashSet<>();
    }

    @Override
    public String toString () {
        return this.name + " = " + this.numbers.toString();
    }
}
