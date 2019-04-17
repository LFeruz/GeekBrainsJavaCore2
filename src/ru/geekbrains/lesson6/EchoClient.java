package ru.geekbrains.lesson6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.print("Введите сообщение > ");
            while (scanner.hasNextLine()) {
                System.out.print("Введите сообщение > ");
                String line = scanner.nextLine();
                out.writeUTF(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
