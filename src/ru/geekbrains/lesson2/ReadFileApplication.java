package ru.geekbrains.lesson2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileApplication {

    private static Scanner openFile(String name) {
        try {
            FileReader fileReader = new FileReader(name);
            // System.exit(0); // только при таком способе завершения программы блок finally не выполняется
            return new Scanner(fileReader);
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException(ex);
        } finally {
            System.out.println("Блок finally выполнен");
        }
    }

    public static void main(String[] args) {
        String fileName = "/Users/macbook/IdeaProjects/GeekBrainsJavaCore2-201804/src/ru/geekbrains/lesson2/ReadFileApplication.java";
        try (Scanner scanner = openFile(fileName)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
