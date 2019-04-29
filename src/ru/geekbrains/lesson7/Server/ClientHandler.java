package ru.geekbrains.lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ru.geekbrains.lesson7.Client.MessagePatterns.MESSAGE_SEND_PATTERN;

public class ClientHandler {

    private final String login;
    private final Socket socket;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final Thread handleThread;
    private ChatServer chatServer;

    public ClientHandler(String login, Socket socket, ChatServer chatServer) throws IOException {
        this.login = login;
        this.socket = socket;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.chatServer = chatServer;

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", login, msg);

                        // TODO проверить является ли msg сообщением для пользователя
                        // TODO если да, то переслать это сообщение пользователю
                        String userTo = "";
                        String message = "";
                        sendMessage(userTo, message);
                        chatServer.sendMessage(userTo, login, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        this.chatServer = chatServer;
        this.handleThread.start();
    }

    public String getLogin() {
        return login;
    }

    public void sendMessage(String userTo, String msg) throws IOException {
        out.writeUTF(String.format(MESSAGE_SEND_PATTERN, userTo, msg));
    }
}
