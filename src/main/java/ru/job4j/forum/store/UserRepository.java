package ru.job4j.forum.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
