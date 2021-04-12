package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        this.users.add(new User(1, "admin", "admin", null));
    }

    public User getUserByName(String name) {
        return this.users.stream().filter(u -> u.getUsername().equals(name)).findFirst().get();
    }

    public void addUser(User user) {
        users.add(user);
    }

}
