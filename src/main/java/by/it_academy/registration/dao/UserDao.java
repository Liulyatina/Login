package by.it_academy.registration.dao;

import by.it_academy.registration.controller.User;
import by.it_academy.registration.dao.api.IUserDao;

import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {
    private static UserDao instance = null;
    private Map<String, User> userMap;

    public UserDao() {
        userMap = new HashMap<>(); // Инициализация хранилища данных
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getLogin(), user);
    }

    @Override
    public User getUserByLogin(String login) {
        System.out.println("Попытка извлечения пользователя с логином: " + login);
        User user = userMap.get(login);
        if (user != null) {
            System.out.println("Пользователь найден: " + user);
        } else {
            System.out.println("Пользователь с логином " + login + " не найден");
        }
        return user;
    }

}
