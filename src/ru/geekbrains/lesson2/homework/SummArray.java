package ru.geekbrains.lesson2.homework;

import java.util.ArrayList;

public class SummArray {

    private static void summ (String [][] arr) throws MyArraySizeException, MyArrayDataException
    {
        if (arr.length != 4) {
            throw new MyArraySizeException(String.format("%s на %s ", arr.length , arr[0].length));
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(String.format("%s на %s ", arr.length , arr[i].length));
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum +=  Integer.parseInt(arr[i][j]);
                 //   System.out.print(arr[i][j]);
                } catch (NumberFormatException ex) { throw new MyArrayDataException(String.format("cтрока '%s' в ячейке [%d][%d] ",  arr[i][j], i, j));
                }
            }
        }
        System.out.println(String.format("Сумма элементов массива %d", sum));
    }

    private static String [][] prepArr (int sizeI, int sizeJ) {
        String [][] arr = new String[sizeI][sizeJ];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.toString(i+j);
            }
        }
        return arr;
    }

    private static void runSumm(String [][] arr) {
        try {
            summ(arr);
        } catch (MyArraySizeException ex){
            System.out.println("Ошибка 1: " + ex);
        } catch (MyArrayDataException ex){
            System.out.println("Ошибка 2: " + ex);
        }
    }

    public static void main(String[] args) {

        String [][] arr1 = new String[4][4];
        String [][] arr2 = new String[4][5];
        String [][] arr3 = new String[3][4];
        String [][] arr4 = new String[4][4];

        arr1 = prepArr(4,4);
        arr2 = prepArr(4,3);
        arr3 = prepArr(3,4);
        arr4 = prepArr(4,4);
        arr4[2][2] = arr4[2][2] + " er";

        String[][] arr ={{"1", "2", "3", "4"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3"}, {"1", "2", "3", "4"}};

        runSumm(arr1);
        runSumm(arr2);
        runSumm(arr3);
        runSumm(arr4);

        runSumm(arr);
    }
}
