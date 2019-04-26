package ru.geekbrains.lesson6.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());

            String user = "Сервер";

            UserHandler userHandler = new UserHandler(socket,scanner,user);
            userHandler.ReciveMess();
            userHandler.sendMess();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
