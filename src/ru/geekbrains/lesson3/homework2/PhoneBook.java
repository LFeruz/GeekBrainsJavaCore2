package ru.geekbrains.lesson3.homework2;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String,Contact> phoneBook;

    public PhoneBook () {
        phoneBook = new HashMap<>();
    }

    public void setContactByName(String name, Integer number) {
        Contact contact;
        if (phoneBook.containsKey(name)){
            contact = phoneBook.get(name);
            contact.addNumber(number);
        } else {
            contact = new Contact(name);
            contact.addNumber(number);
            phoneBook.put(name,contact);
        }

    }

    public Contact getContactsByName(String name) {
        Contact contact;
        if (phoneBook.containsKey(name)){
            contact = phoneBook.get(name);
        } else {
            contact = new Contact(name);
        }
        return contact;
    }

}
