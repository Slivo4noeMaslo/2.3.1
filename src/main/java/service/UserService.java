package service;

import dao.UserDaoImpl;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }
}
