package ru.geekbrains.lesson7.homework.Client;

public final class MessagePatterns {

    public static final String AUTH_PATTERN = "/auth %s %s";

    public static final String MESSAGE_PREFIX = "/w";
    public static final String MESSAGE_SEND_PATTERN = MESSAGE_PREFIX+" %s %s %s";

    public static TextMessage parseTextMessage(String text) {
        String[] parts = text.split(" ", 4);
        if (parts.length == 4 && parts[0].equals(MESSAGE_PREFIX)) {
            return new TextMessage(parts[1], parts[2], parts[3]);
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }
}
