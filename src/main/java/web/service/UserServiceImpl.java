package web.service;

import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Transactional(readOnly = true)
    @Override
    public User getUser(int id) {

        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void editUser(int id, User user) {

        userDao.editUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {

        userDao.deleteUser(id);
    }
}

