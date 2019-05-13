package ru.geekbrains.lesson8.Server.auth;

import ru.geekbrains.lesson8.Server.User;

public interface AuthService {

    boolean authUser(User user);
}
