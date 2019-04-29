package ru.geekbrains.lesson7.auth;

import ru.geekbrains.lesson7.User;

public interface AuthService {

    boolean authUser(User user);
}
