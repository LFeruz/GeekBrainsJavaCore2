package ru.geekbrains.lesson3.homework1;

import java.util.Map;

public class UniqueWords  {


    public static void main(String[] args) {
        String [] arr ={"раз","раз","раз","два","три",
                        "три", "четыре", "три", "пять", "раз"};

        Map UWords = new UniqueHashMap();
        for (int i = 0; i < arr.length; i++) {
            ((UniqueHashMap) UWords).putUniq(arr[i]);
        }
            System.out.println(UWords);
    }
}
