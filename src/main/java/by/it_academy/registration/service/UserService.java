package by.it_academy.registration.service;

import by.it_academy.registration.controller.User;
import by.it_academy.registration.dao.UserDao;
import by.it_academy.registration.service.api.IUserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {
    private final Map<String, User> userMap = new HashMap<>();

    private final UserDao userDao = UserDao.getInstance();

    public UserService(UserDao userDao) {
    }

    @Override
    public User registerUser(String login, String password, String fullName, LocalDate birthDate) {

        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }

        // Проверяем, что пароль не пустой и имеет достаточную длину
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password cannot be empty and must be at least 6 characters long");
        }

        // Проверяем, что полное имя не пустое
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }

        // Проверяем, что дата рождения не пустая и что пользователь достиг совершеннолетия
        if (birthDate == null || birthDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Invalid birth date. User must be at least 18 years old");
        }

        // Проверяем, что пользователь с таким логином еще не зарегистрирован
        if (userDao.getUserByLogin(login) != null) {
            throw new IllegalArgumentException("User with this login already exists");
        }

        User user = new User(login, password, fullName, birthDate, LocalDate.now(), "пользователь");
        userDao.addUser(user);
        return user;
    }

    @Override
    public boolean loginUser(String login, String password) {
        // Получаем пользователя по логину
        User user = userDao.getUserByLogin(login);

        // Проверяем, найден ли пользователь
        if (user == null) {
            // Пользователь с указанным логином не найден
            return false;
        }

        // Проверяем совпадение паролей
        return user.getPassword().equals(password);
    }

    public void addUser(User user) {
        userMap.put(user.getLogin(), user);
    }

    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

}

