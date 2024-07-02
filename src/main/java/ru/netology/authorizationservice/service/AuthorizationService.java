package ru.netology.authorizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.model.User;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.List;


// Класс-сервис, который будет обрабатывать введённые логин и пароль
// Он принимает в себя логин и пароль и возвращает разрешения для этого пользователя,
// если такой пользователь найден и данные валидны.
@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public List<Authorities> getAuthorities(User user) {
        return getAuthorities(user.getUser(), user.getPassword());
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }



}
