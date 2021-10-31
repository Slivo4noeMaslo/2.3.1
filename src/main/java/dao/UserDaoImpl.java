package dao;

import models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(int id, User user) {
        User userToBeUpdate = getUserById(id);
        entityManager.refresh(userToBeUpdate);
        userToBeUpdate.setName(user.getName());
        userToBeUpdate.setSurname(user.getSurname());
        userToBeUpdate.setAge(user.getAge());
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u From User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
