package by.it_academy.registration.dao.api;

import by.it_academy.registration.controller.User;

public interface IUserDao {
    void addUser(User user);

    User getUserByLogin(String login);
}
