package ru.geekbrains.lesson2;

import java.util.Scanner;

public class CalcApplication {

    private static void calc(int num1, int num2, String operation) throws WrongOperationException {
        switch (operation) {
            case "+":
                System.out.println(String.format("%d%s%d=%d", num1, operation, num2, num1 + num2));
                break;
            case "-":
                System.out.println(String.format("%d%s%d=%d", num1, operation, num2, num1 - num2));
                break;
            case "*":
                System.out.println(String.format("%d%s%d=%d", num1, operation, num2, num1 * num2));
                break;
            case "/":
                System.out.println(String.format("%d%s%d=%d", num1, operation, num2, num1 / num2));
                break;
            default:
                throw new WrongOperationException("Неизвестная операция " + operation);
        }
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Введите первое число:");
                    int num1 = Integer.valueOf(scn.nextLine());

                    System.out.println("Введите второе число:");
                    int num2 = Integer.valueOf(scn.nextLine());

                    System.out.println("Введите операцию:");
                    String operation = scn.nextLine();

                    calc(num1, num2, operation);
                } catch (NumberFormatException ex) {
                    System.out.println("Ошибка преобразования числа " + ex);
                } catch (ArithmeticException ex) {
                    System.out.println("Арифметическая ошибка " + ex);
                } catch (WrongOperationException ex) {
                    System.out.println("Ошибка " + ex);
                } catch (Exception ex) {
                    System.out.println("Неизвестная ошибка: " + ex);
                }
            }
        }
    }
}
