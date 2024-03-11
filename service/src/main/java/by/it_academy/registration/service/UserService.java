package by.it_academy.registration.service;

import by.it_academy.registration.dao.UserDao;
import by.it_academy.registration.dao.dto.UserDto;
import by.it_academy.registration.dao.api.IUserDao;
import by.it_academy.registration.dao.factory.DaoFactory;
import by.it_academy.registration.service.api.IUserService;

import java.time.LocalDate;

public class UserService implements IUserService {
    private final IUserDao userDao = DaoFactory.getUserDao();

    public UserService(UserDao userDao) {
    }

    @Override
    public UserDto save(String login, String password, String fullName, LocalDate birthDate) {

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

        UserDto user = new UserDto(login);
        userDao.addUser(login, password, fullName, birthDate);
        return user;
    }

    @Override
    public boolean getUserByLogin(String login, String password) {
        return userDao.getUserByLogin(login, password);
    }
}
