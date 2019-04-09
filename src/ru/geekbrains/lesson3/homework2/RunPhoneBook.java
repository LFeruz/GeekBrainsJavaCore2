package ru.geekbrains.lesson3.homework2;

public class RunPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setContactByName("Вася",123);
        phoneBook.setContactByName("Вася",2222);
        phoneBook.setContactByName("Петя",3333);
        phoneBook.setContactByName("Коля",44444);
        phoneBook.setContactByName("Петя",124124);



        System.out.println(phoneBook.getContactsByName("Вася"));
        System.out.println(phoneBook.getContactsByName("Петя"));
        System.out.println(phoneBook.getContactsByName("Коля"));
        System.out.println(phoneBook.getContactsByName("Гриша"));

    }
}
