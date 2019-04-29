package ru.geekbrains.lesson7.homework.Server.auth;

import ru.geekbrains.lesson7.homework.Server.User;

public interface AuthService {

    boolean authUser(User user);
}
