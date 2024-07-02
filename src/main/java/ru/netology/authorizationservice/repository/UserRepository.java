package ru.netology.authorizationservice.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.User;
import ru.netology.authorizationservice.service.InvalidCredentials;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    @Getter
    public static Set<User> users = ConcurrentHashMap.newKeySet();

    public UserRepository() {
        users.add(new User("User_1", "password_1", true, true, true));
        users.add(new User("User_2", "password_2", true, false, false));
        users.add(new User("User_3", "password_3", false, false, false));
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        for (User user1 : users) {
            if (user1.getUser().equals(user) && user1.getPassword().equals(password)) {
                return user1.getAuthorities();
            }
        }

        throw new InvalidCredentials("User name or password is empty");
    }

}
