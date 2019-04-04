package ru.geekbrains.lesson2;

public class NpeApplication {

    public void method() {

    }

    public static void main(String[] args) {

        // deboxing значения null
        try {
            Integer intObj = null;
            int val = intObj;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        // итерирование не инициализированного массива
        try {
            int[] arr = null;
            for (int val : arr) {
                System.out.println(val);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        // вызов методов не созданного объекта
        try {
            NpeApplication app = null;
            app.method();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        // сравнение null-строки
        try {
            String str = null;
            str.equals("sdfsdf");

            // правильно так
            "sdfsdf".equals(str);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
