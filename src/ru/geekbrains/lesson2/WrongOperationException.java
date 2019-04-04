package ru.geekbrains.lesson2;

public class WrongOperationException extends Exception {

    public WrongOperationException(String operation) {
        super("Неизвестная операция " + operation);
    }

    public WrongOperationException(String operation, Throwable cause) {
        this(operation);
    }
}
