package ru.geekbrains.lesson5;

public class SendReceive {

    private String packet;

    private volatile boolean packetReady = false;

    public synchronized void send(String packet) {
        while (packetReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        packetReady = true;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String recieve() {
        while (!packetReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        packetReady = false;
        notifyAll();
        return packet;
    }
}
