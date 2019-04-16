package ru.geekbrains.lesson5;

public class ThreadApp {

    public static class NewThread extends Thread {

        @Override
        public void run() {
            System.out.printf("2 Привет из нового потока ThreadId %d!!!%n",
                    Thread.currentThread().getId());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.printf("Основной поток ThreadId %d!!!%n", Thread.currentThread().getId());

        // Способы создания нового потока

        // 1
        new Thread() {

            @Override
            public void run() {
                System.out.printf("1 Привет из нового потока ThreadId %d!!!%n",
                        Thread.currentThread().getId());
            }
        }.start();

        // 2
        NewThread newThread = new NewThread();
        newThread.setDaemon(true);
        newThread.start();

        // 3
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.printf("3 Привет из нового потока ThreadId %d!!!%n",
                        Thread.currentThread().getId());
            }
        }).start();

        // 4
        new Thread(() -> System.out.printf("4 Привет из нового потока ThreadId %d!!!%n",
                Thread.currentThread().getId())).start();
    }
}
