package ru.netology.authorizationservice.model;

import lombok.Getter;
import lombok.Setter;
import ru.netology.authorizationservice.repository.Authorities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    @NotEmpty
    @Size(min = 5, max = 20)
    private String user;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @Setter
    @Getter
    private List<Authorities> authorities = new ArrayList<>();


    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user, String password, boolean read, boolean write, boolean delete) {
        this.user = user;
        this.password = password;
        setRead(read);
        setWrite(write);
        setDelete(delete);
    }

    public void setRead(boolean read) {
        if (read && !this.authorities.contains(Authorities.READ)) {
            this.authorities.add(Authorities.READ);
        } else this.authorities.remove(Authorities.READ);
    }

    public void setWrite(boolean write) {
        if (write && !this.authorities.contains(Authorities.WRITE)) {
            this.authorities.add(Authorities.WRITE);
        } else this.authorities.remove(Authorities.WRITE);
    }

    public void setDelete(boolean delete) {
        if (delete && !this.authorities.contains(Authorities.DELETE)) {
            this.authorities.add(Authorities.DELETE);
        } else this.authorities.remove(Authorities.DELETE);
    }

    public @NotEmpty @Size(min = 5, max = 20) String getUser() {
        return user;
    }

    public void setUser(@NotEmpty @Size(min = 5, max = 20) String user) {
        this.user = user;
    }


    public @NotEmpty @Size(min = 8, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty @Size(min = 8, max = 20) String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
