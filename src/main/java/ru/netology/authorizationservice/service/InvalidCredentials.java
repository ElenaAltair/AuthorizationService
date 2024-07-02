package ru.netology.authorizationservice.service;

// присланные пользователем данные неверны, тогда выкидывается InvalidCredentials
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
