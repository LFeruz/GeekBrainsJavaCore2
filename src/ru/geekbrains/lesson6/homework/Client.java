package ru.geekbrains.lesson6.homework;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            String user = "Клиент";

            UserHandler userHandler = new UserHandler(socket,scanner,user);
            userHandler.ReciveMess();
            userHandler.sendMess();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
