package ru.geekbrains.lesson8.homework.Client;


import java.util.ArrayList;

public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);

    void setUserList(ArrayList<String> users);
}
