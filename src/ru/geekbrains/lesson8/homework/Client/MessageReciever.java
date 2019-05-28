package ru.geekbrains.lesson8.homework.Client;


import java.util.ArrayList;
import java.util.Set;

public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);

    //void setUserList(ArrayList<String> users);
    void setUserList(Set<String> users);
}
