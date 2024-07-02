package ru.netology.authorizationservice.service;

// Если ваш репозиторий не вернул никаких разрешений,
// либо вернул пустую коллекцию, тогда выкидывается ошибка UnauthorizedUser
public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
