package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                try {
                    System.out.println("Новое сообщение > " + in.readUTF());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
