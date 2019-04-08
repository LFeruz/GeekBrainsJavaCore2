package ru.geekbrains.lesson2.homework;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String data) {
        super("Ошибка формата массива " + data);
    }

    public MyArrayDataException(String data, Throwable cause) {
        this(data);
    }
}