package ru.geekbrains.lesson8.homework.Server.auth;

import ru.geekbrains.lesson8.homework.Server.User;

public interface AuthService {

    boolean authUser(User user);
}
