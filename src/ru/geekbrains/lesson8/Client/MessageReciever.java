package ru.geekbrains.lesson8.Client;


import java.util.ArrayList;

public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);

    void getUserList(ArrayList<String> userList);
}
