package ru.geekbrains.lesson5;

public class SendReceiveApp {

    private static SendReceive sendReceive = new SendReceive();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Prepearing package");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendReceive.send("Something");
            }
        }).start();

        System.out.println("Incoming packet: " + sendReceive.recieve());
    }
}
