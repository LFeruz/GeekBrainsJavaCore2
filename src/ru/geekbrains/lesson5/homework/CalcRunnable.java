package ru.geekbrains.lesson5.homework;

public class CalcRunnable  implements Runnable {
        private static float [] arr;
        private static int cnt;
        private static int offset;

    public static void calcRun (float[] arr, int cnt, int offset) {
        for (int i = offset; i < cnt; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
        public CalcRunnable (float [] arr, int cnt, int offset){
            this.arr = arr;
            this.cnt = cnt;
            this.offset = offset;
        }

        @Override
        public void run() {
            calcRun(arr,cnt,offset);
        }
    }

