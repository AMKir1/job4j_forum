package ru.job4j.forum.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

@Service
public class UserService {

    private final UserRepository users;
    private final JdbcTemplate template;

    public UserService(UserRepository users, JdbcTemplate template) {
        this.users = users;
        this.template = template;
    }

    public boolean getUserByName(String name) {
        return this.template.queryForList("SELECT * FROM users u WHERE u.username = ?", name).size() > 0;
    }

    public void addUser(User user) {
        users.save(user);
    }

}
