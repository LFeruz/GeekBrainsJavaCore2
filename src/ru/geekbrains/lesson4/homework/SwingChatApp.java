package ru.geekbrains.lesson4.homework;

import javax.swing.*;

public class SwingChatApp {

    private static MainChatWindow mainChatWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainChatWindow = new MainChatWindow();
            }
        });
    }
}
