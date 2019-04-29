package ru.geekbrains.lesson7.Server.auth;

import ru.geekbrains.lesson7.Server.User;

public interface AuthService {

    boolean authUser(User user);
}
