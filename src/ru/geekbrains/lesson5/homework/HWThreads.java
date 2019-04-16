package ru.geekbrains.lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWThreads {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void calc (float[] arr, int cnt, int offset) {
        for (int i = offset; i < cnt; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        long stTime;

        Arrays.fill(arr,1);

        float[] arr10 = arr;

        // без потоков
        stTime =  System.currentTimeMillis();
        calc(arr, SIZE,0);
        System.out.printf(" without thread time: %d%n", System.currentTimeMillis() - stTime);


        // с потоками без arraycopy с наследованием от Thread
        stTime = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();


        for (int i= 0;i < 2; i++){
            Thread newThread = new CalcThread(arr10, H, i* H);
            threadList.add(newThread);
            newThread.start();
        }

        for (Thread thr : threadList) {
            thr.join();
        }
        System.out.printf(" thread time: %d%n", System.currentTimeMillis() - stTime);

        /* проверка
        for (int i = 0; i < arr.length;i++){
            if (arr[i] == arr10[i]){
                System.out.println(arr[i] + "   " + arr10[i] );
            }
        }*/

        // с потоками с arraycopy с имплеминтацией Runnable
        stTime =  System.currentTimeMillis();

        float [] arr1 = new float[H];
        float [] arr2 = new float[H];

        System.arraycopy(arr,0,arr1,0, H);
        System.arraycopy(arr, H,arr2,0, H);
        List<Thread> threadList2 = new ArrayList<>();
        Thread  RunnableCalc1 = new Thread(new CalcRunnable(arr1, H, 0));
        threadList2.add(RunnableCalc1);
        RunnableCalc1.start();
        Thread  RunnableCalc12= new Thread(new CalcRunnable(arr2, H, 0));
        threadList2.add(RunnableCalc12);
        RunnableCalc12.start();
        for (Thread thr : threadList2) {
            thr.join();
        }
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);

        System.out.printf(" thread with copy time: %d%n", System.currentTimeMillis() - stTime);
    }

}