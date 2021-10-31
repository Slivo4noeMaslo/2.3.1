package dao;

import models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(int id, User user);
    List<User> getAllUser();
    User getUserById(int id);
}
