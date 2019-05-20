package ru.geekbrains.lesson8.homework.Client;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessagePatterns {

    public static final String AUTH_PATTERN = "/auth %s %s";
    public static final String AUTH_SUCCESS_RESPONSE = "/auth successful";
    public static final String AUTH_FAIL_RESPONSE = "/auth fail";

    public static final String DISCONNECT = "/disconnect";
    public static final String DISCONNECT_SEND = DISCONNECT + " %s";

    public static final String CONNECTED = "/connected";
    public static final String CONNECTED_SEND = CONNECTED + " %s"
            ;

    public static final String CONNECTED_ALLREDY = CONNECTED + " %s";

    public static final String MESSAGE_PREFIX = "/w";
    public static final String MESSAGE_SEND_PATTERN = MESSAGE_PREFIX + " %s %s";

    public static final Pattern MESSAGE_REC_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);

    public static final String GET_USER_LIST = "/getuserlist";
    public static final String GET_USER_LIST_RESPONCE = GET_USER_LIST + " %s";

    public static TextMessage parseTextMessageRegx(String text, String userTo) {
        Matcher matcher = MESSAGE_REC_PATTERN.matcher(text);
        if (matcher.matches()) {
            return new TextMessage(matcher.group(1), userTo,
                    matcher.group(2));
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static TextMessage parseTextMessage(String text, String userTo) {
        String[] parts = text.split(" ", 3);
        if (parts.length == 3 && parts[0].equals(MESSAGE_PREFIX)) {
            return new TextMessage(parts[1], userTo, parts[2]);
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static String parseConnectedMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length == 2 && parts[0].equals(CONNECTED)) {
            return parts[1];
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static String parseDisconnectedMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length == 2 && parts[0].equals(DISCONNECT)) {
            return parts[1];
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

/*    public static ArrayList<String> parseGetUserListMessage(String text) {
        String[] parts = text.split(" ");
        ArrayList<String> UserList = new ArrayList();
        System.out.println(parts.length);
        System.out.println(parts[0]);
        if (parts.length > 1 && parts[0].equals(GET_USER_LIST)) {
            for (int i=1;i<=parts.length;i++) {
                System.out.println(parts[i]);
                UserList.add(parts[i]);
            };
            return UserList;
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }
*/
    public static Set<String> parseGetUserListMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length >= 1 && parts[0].equals(GET_USER_LIST)) {
            Set<String> users = new HashSet<>();
            for (int i=1; i<parts.length; i++) {
                users.add(parts[i]);
            }
            return users;
        } else {
            System.out.println("Not a user list pattern: " + text);
            return null;
        }
    }
}
