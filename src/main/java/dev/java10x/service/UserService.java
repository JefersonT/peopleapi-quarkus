package dev.java10x.service;

import dev.java10x.domain.User;
import dev.java10x.exceptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public User createUser(User user) {
        user.persist();
        return user;
    }

    public List<User> findAllUsers(Integer page, Integer asdf) {
         return User.findAll().page(page, asdf).list();
    }

    public User findUserById(UUID userId) {
        return (User) User.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(UUID id, User user) {
        var userToUpdate = findUserById(id);

        userToUpdate.username = user.username;
        userToUpdate.email = user.email;

        User.persist(userToUpdate);
        return userToUpdate;
    }

    public void deleteUser(UUID userId) {
        findUserById(userId);
        User.deleteById(userId);
    }
}
