package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiEchoServer {

    private static int counter;

    private static List<Thread> clientHandlers = new ArrayList<>();

    static class ClientHandler implements Runnable {

        private Socket socket;
        private int id;

        public ClientHandler(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }

        @Override
        public void run() {
            try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.printf("Новое сообщение [%d]> %s%n", id, in.readUTF());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер ожидает подключения!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Кто-то подключился: " + socket.getInetAddress());

                Thread thread = new Thread(new ClientHandler(socket, ++counter));
                thread.start();
                clientHandlers.add(thread);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            for (Thread thread : clientHandlers) {
                thread.interrupt();
            }
        }
    }
}