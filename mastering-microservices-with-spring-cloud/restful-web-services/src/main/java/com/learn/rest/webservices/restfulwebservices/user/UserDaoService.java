package com.learn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(25)));
    }
    // find all users
    public List<User> findAll() {
        return users;
    }

    // find a single user
    public User findOne(Integer id) {
        return users.stream()
                .filter(user -> Objects.equals(id, user.getId()))
                .findFirst()
                .orElse(null);
    }

    // save a user
    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    // delete a user
    public void deleteById(Integer id) {
        users.removeIf(user -> id.equals(user.getId()));
    }
}
