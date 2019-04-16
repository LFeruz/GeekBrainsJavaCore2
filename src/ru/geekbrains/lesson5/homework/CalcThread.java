package ru.geekbrains.lesson5.homework;


public class CalcThread extends Thread{
    private float [] arr;
    private int cnt;
    private int offset;

    public static void CalcRun (float[] arr, int cnt, int offset) {
        for (int i = offset; i < cnt; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public CalcThread (float [] arr, int cnt, int offset){
        this.arr = arr;
        this.cnt = cnt;
        this.offset = offset;
    }

    @Override
    public void run() {
        CalcRun(arr,cnt,offset);
    }
}

