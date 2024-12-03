package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User getUser(int id);

    void editUser(int id, User user);

    void deleteUser(int id);
}

