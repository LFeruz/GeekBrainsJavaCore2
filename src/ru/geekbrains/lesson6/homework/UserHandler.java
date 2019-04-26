package ru.geekbrains.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class UserHandler  {
    private Socket socket;
    private Scanner scaner;
    private String user;

    public UserHandler (Socket socket,
                       Scanner scanner,
                       String user){
        this.socket = socket;
        this.scaner = scanner;
        this.user = user;

    }
    public void sendMess () {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (scaner.hasNextLine()) {
                String line = scaner.nextLine();
                out.writeUTF(user+": "+line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ReciveMess () {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Thread inThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(in.readUTF());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                }
            });
            inThread.setDaemon(true);
            inThread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
