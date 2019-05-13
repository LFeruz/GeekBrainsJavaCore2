package ru.geekbrains.lesson8.Client;


public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);
}
