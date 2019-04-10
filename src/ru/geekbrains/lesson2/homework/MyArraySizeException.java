package ru.geekbrains.lesson2.homework;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(String size) {
        super("Ошибка размера массива " + size);
    }

    public MyArraySizeException(String size, Throwable cause) {
        this(size);
    }
}

