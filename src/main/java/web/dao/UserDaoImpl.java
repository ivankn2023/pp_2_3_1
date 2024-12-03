package web.dao;


import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;


    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {

        return entityManager.createQuery(" FROM User").getResultList();

    }

    @Override
    public User getUser(int id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(int id, User user) {

        User editable = entityManager.find(User.class, id);
        editable.setName(user.getName());
        editable.setSurname(user.getSurname());
        editable.setAge(user.getAge());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
