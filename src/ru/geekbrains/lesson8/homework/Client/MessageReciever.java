package ru.geekbrains.lesson8.homework.Client;


public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);
}
